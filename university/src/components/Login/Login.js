import { useContext, useState } from 'react';
import './Login.css'
import { MyUserContext } from '../../App';
import Apis, { authApi, endpoints } from '../../configs/Apis';
import { Navigate } from 'react-router-dom';
import { Form } from 'react-bootstrap';
import cookie from "react-cookies";

const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const login = (evt) => {
        evt.preventDefault();

        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });
                cookie.save("token", res.data);

                let { data } = await authApi().get(endpoints['current-user']);
                cookie.save("user", data);
                console.info(data);

                dispatch({
                    "type": "login",
                    "payload": data
                });
            } catch (err) {
                console.error(err);
            }
        }

        process();
    }


    if (user !== null)
        return <Navigate to="/" />

    return <>
        <Form onSubmit={login} className="Auth-form-container">
            <div className="Auth-form">
                <div className="Auth-form-content">
                    <h3 className="Auth-form-title">Đăng nhập</h3>
                    <div className="form-group mt-3">
                        <label>Tài khoản</label>
                        <input
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                            type="text"
                            className="form-control mt-1"
                            placeholder="Nhập tài khoản"
                        />
                    </div>
                    <div className="form-group mt-3">
                        <label>Mật khẩu</label>
                        <input
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            type="password"
                            className="form-control mt-1"
                            placeholder="Nhập mật khẩu"
                        />
                    </div>
                    <div className="d-grid gap-2 mt-3">
                        <button type="submit" className="btn btn-primary">
                            Đăng nhập
                        </button>
                    </div>
                    <p className="forgot-password text-right mt-2">
                        Quên <a href="#">mật khẩu?</a>
                    </p>
                </div>
            </div>
        </Form>
    </>
}

export default Login;