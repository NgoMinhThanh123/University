import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/University";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "subjects": `${SERVER_CONTEXT}/api/subjects/`,
    "faculties": `${SERVER_CONTEXT}/api/faculties/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
}

export const authApi = () => {
    return axios.create({
        baseURL: SERVER,
        headers: {
            "Authorization":  cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
})