import { useContext, useState } from "react";
import { MyUserContext } from "../../App";
import Apis, { authApi, endpoints } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";
import { useEffect } from "react";
import { Link } from "react-router-dom";
import './Post.css'
import { Button } from "react-bootstrap";
import formatDate from "../FormatDare/FormatDate";
import moment from 'moment';

const Post = () => {
    const [user] = useContext(MyUserContext);
    const [post, setPost] = useState([]);
    const [showInput, setShowInput] = useState(false);
    const [title, setTitle] = useState();
    const [content, setContent] = useState();

    useEffect(() => {
        const loadPost = async () => {
            let { data } = await Apis.get(endpoints['posts']);
            setPost(data);
        }

        loadPost();
    }, []);

    console.log(post);

    const handleToggleInput = () => {
        setShowInput(!showInput);
    };

    const handlePostSubmit = () => {
        const process = async () => {
            let { data } = await authApi().post(endpoints['add-post'], {
                "title": title,
                "content": content,
            });

            setPost([...post, data]);

            setTitle("");
            setContent(""); 
            setShowInput(false);
        }

        process();
    };

    if (post === null)
        return <MySpinner />

    return (
        <div>
            <h3 className="forum">Diễn đàn thảo luận môn học</h3>
            {!showInput && (
                <Button onClick={handleToggleInput}>Đăng bài</Button>
            )}
            {showInput && (
                <div className="post-container">
                    <div>
                        <p className="title">Tiêu đề</p>
                        <textarea className="inputTitle" placeholder="Nhập tiêu đề bài viết"
                            value={title} onChange={e => setTitle(e.target.value)}></textarea>
                    </div>
                    <div>
                        <p className="title">Nội dung</p>
                        <textarea className="inputContent" placeholder="Nhập nội dung bài viết"
                            value={content} onChange={e => setContent(e.target.value)}></textarea>
                    </div>
                    <Button className="btn-title btnSubmitTile" onClick={handlePostSubmit}>Đăng</Button>
                    <Button className="btn-title btnCancelTile" onClick={handleToggleInput}>Hủy</Button>
                </div>
            )}
            {post.length > 0 && (
                <table className="table">
                    <thead>
                        <tr>
                            <th>Tên bài post</th>
                            <th>Người đăng</th>
                            <th>Thời gian đăng</th>
                        </tr>
                    </thead>
                    <tbody>
                        {post.map(p => (
                            <tr key={p.id}>
                                <td>
                                    <Link to={`/posts/${p.id}`} className="post-link">
                                        {p.title}
                                    </Link>
                                </td>
                                <td>{p.userId.username}</td>
                                <td>{formatDate(p.postTime)}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            )}
        </div>
    );

}


export default Post