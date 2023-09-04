import { useState } from "react";
import { useParams } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../../configs/Apis";
import { useEffect } from "react";
import MySpinner from "../../layout/MySpinner";
import formatDate from "../FormatDare/FormatDate";
import { useContext } from "react";
import { MyUserContext } from "../../App";
import "./Post.css"

const PostDetail = () => {
    const [user,] = useContext(MyUserContext);
    const [usernameHost, setUsernameHost] = useState(null);
    const { postId } = useParams();
    const [post, setPost] = useState(null);
    const [comment, setComment] = useState(null);
    const [content, setContent] = useState();

    useEffect(() => {
        const loadProduct = async () => {
            let { data } = await Apis.get(endpoints['details'](postId));
            setPost(data);

            const loadUser = async () => {
                const userInfo = await authApi().get(endpoints['user-id'].replace("{id}", data.userId.id)); // Sử dụng data.userId thay vì post.userId
                setUsernameHost(userInfo.data.username);
            }

            loadUser();
        }

        const LoadComment = async () => {
            const data = await authApi().get(endpoints['comments'].replace("{id}", postId));
            console.log(data.data);

            setComment(data.data);
        }

        loadProduct();
        LoadComment();

    }, []);

    console.log(post.userId.id);

    const addComment = () => {
        const process = async () => {
            let { data } = await authApi().post(endpoints['add-comment'], {
                "content": content,
                "postId": post.id
            });

            setComment([...comment, data]);
        }

        process();
    }


    if (post === null || comment === null) {
        return <MySpinner />;
    }
    console.log(comment);
    return <>
        <div>
            <div className="post-container">
                <p className="postDetail">{post.title}</p>
                <p className="userDetail">Đăng bởi: {usernameHost} - Thời gian: {formatDate(post.postTime)}</p>           
                <p>{post.content}</p>           
            </div>
            <hr />  
            <h3 className="comment-title">Bình luận</h3>

            <Form.Control as="textarea" aria-label="With textarea" value={content} onChange={e => setContent(e.target.value)} placeholder="Nội dung bình luận" />
            <Button onClick={addComment} className="mt-2" variant="info">Bình luận</Button>      
        <hr />

        {comment && comment.map(p => {
            return <div key={p.id} className="post-container">
                <div className="post-row">
                    <p className="postDetail">{p.userId.username}- {formatDate(p.dateCreated)}</p>
                    <p>{p.content}</p>
                </div>
            </div>
        })}
    </div >
        </>
};

export default PostDetail;  