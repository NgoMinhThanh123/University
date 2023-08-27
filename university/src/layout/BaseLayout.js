import { Container } from "react-bootstrap";
import Footer from "./Footer/Footer";
import Header from "./Header/Header";

function BaseLayout({ children }) {
    return (
      <div className="">
        <Header />
        <Container>
          <div className="">{children}</div>
        </Container>
        <Footer />
      </div>
    );
}

  export default BaseLayout;
