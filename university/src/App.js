import { BrowserRouter, Route, Routes } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./components/Login/Login";
import BaseLayout from "./layout/BaseLayout";
import Home from "./components/Home/Home";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  return (
    <MyUserContext.Provider value={[user, dispatch]}>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<BaseLayout><Home /></BaseLayout>} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
    </MyUserContext.Provider>
  )
}

export default App;