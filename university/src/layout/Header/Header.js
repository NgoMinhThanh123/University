import { Button, Container, Nav, Navbar} from "react-bootstrap";
import { MyUserContext } from "../../App";
import { useContext } from "react";
import { Link } from "react-router-dom";
import './Header.css'

const Header = () => {
  const [user, dispatch] = useContext(MyUserContext);

  const logout = () => {
    dispatch({
        "type": "logout"
    })
  }

    return (
    <>
    <Navbar expand="lg" className="bg-body-tertiary back-ground">
      <Container>
        <Navbar.Brand href="#home">Quản lý sinh viên</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link className="nav-link" to="/">Trang chủ</Link>
            <Link className="nav-link" to="/profile">Hồ sơ</Link>
            {user.role === "ROLE_GIANGVIEN" && (
                <Link className="nav-link" to="/student">
                  Sinh viên
                </Link>
              )}
              {user.role === "ROLE_SINHVIEN" && (
                <Link className="nav-link" to="/score">
                  Điểm
                </Link>
              )}
            <Link className="nav-link" to="/forum">Diễn đàn</Link>
            <Link className="nav-link" to="/chat">Chat</Link>
            {user === null ? <Link className="nav-link" to="/login">Đăng nhập</Link>:<>
              <Link className="nav-link" to="/login">Chào {user.username}!</Link>
              <Link className="nav-link" variant="secondary" onClick={logout} to="/login">Đăng xuất</Link>
            </>}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </>
    )
}

export default Header