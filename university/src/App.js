  import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
  import 'bootstrap/dist/css/bootstrap.min.css';
  import Login from "./components/Login/Login";
  import BaseLayout from "./layout/BaseLayout";
  import Home from "./components/Home/Home";
  import { createContext, useContext, useReducer, useState } from "react";
  import MyUserReducer from "./reducers/MyUserReducer";
  import cookie from "react-cookies";
  import Register from "./components/Register/Register";
  import HomeChat from "./components/Chat/HomeChat";
import Score from "./components/Score/Score";
import Profile from "./components/Profile/Profile";
import QuestionList from "./components/Forum/QuestionList";
import Student from "./components/Student/Student";

  export const MyUserContext = createContext();

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  return (
    <MyUserContext.Provider value={{ user, setUser }}>
      {children}
    </MyUserContext.Provider>
  );
};

export const useUser = () => useContext(MyUserContext);

  const App = () => {
    const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
    const ProtectedRoute = ({ children }) => {
      if (!user) {
        return <Navigate to="/login" />;
      }
      return children;
    };
    return (
      <MyUserContext.Provider value={[user, dispatch]}>
      <BrowserRouter>
        <Routes>
        
          <Route path="/" element={ <ProtectedRoute><BaseLayout><Home /></BaseLayout></ProtectedRoute>} />
          <Route path="/chat" element={ <ProtectedRoute><BaseLayout><HomeChat /></BaseLayout></ProtectedRoute>} />
          <Route path="/score" element={ <ProtectedRoute><BaseLayout><Score /></BaseLayout></ProtectedRoute>} />
          <Route path="/student" element={ <ProtectedRoute><BaseLayout><Student /></BaseLayout></ProtectedRoute>} />
          <Route path="/profile" element={ <ProtectedRoute><BaseLayout><Profile /></BaseLayout></ProtectedRoute>} />
          <Route path="/forum" element={ <ProtectedRoute><BaseLayout><QuestionList /></BaseLayout></ProtectedRoute>} />
          {/* <Route path="/" element={ <BaseLayout><Home /></BaseLayout> }/>
          <Route path="/chat" element={<BaseLayout><HomeChat /></BaseLayout> }/> */}
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </BrowserRouter>
      </MyUserContext.Provider>
    )
  }

  export default App;