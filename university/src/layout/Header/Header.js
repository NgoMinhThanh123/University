import { Button, Container, Nav, Navbar} from "react-bootstrap";
import { MyUserContext } from "../../App";
import { useContext } from "react";
import { Link } from "react-router-dom";

const Header = () => {
  const [user, dispatch] = useContext(MyUserContext);

  const logout = () => {
    dispatch({
        "type": "logout"
    })
  }

    return (
    <>
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <Navbar.Brand href="#home">Quản lý sinh viên</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link className="nav-link" to="/">Trang chủ</Link>
            <Link className="nav-link" to="/">Hồ sơ</Link>
            <Link className="nav-link" to="/">Sinh viên</Link>
            <Link className="nav-link" to="/">Điểm</Link>
            <Link className="nav-link" to="/">Thông báo</Link>
            <Link className="nav-link" to="/">Chat</Link>
            {user === null ? <Link className="nav-link" to="/login">Chat</Link>:<>
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