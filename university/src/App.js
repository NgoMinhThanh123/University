import { Container } from "react-bootstrap";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Footer from "./layout/Footer";
import Header from "./layout/Header";

const App = () => {

  return (
      <BrowserRouter>
        <Header />
        <Container>
          <Routes>
            <Route path="/" element={<Home />} />
          </Routes>
        </Container>
        <Footer />
      </BrowserRouter>
  )
}

export default App;