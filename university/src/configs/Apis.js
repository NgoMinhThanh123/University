import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/University";
const SERVER = "http://localhost:8080";

export const endpoints = {
    // "subjects": `${SERVER_CONTEXT}/api/subjects/`,
    // "faculties": `${SERVER_CONTEXT}/api/faculties/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
    "semester": `${SERVER_CONTEXT}/api/semesters/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "get-user": `${SERVER_CONTEXT}/api/users/{username}/`,
    "get-student-by-username": `${SERVER_CONTEXT}/api/students-un/{username}/`,
    "get-lecturer-by-username": `${SERVER_CONTEXT}/api/lecturers-un/{username}/`,
    "get-student-by-lecturer-subject-id": `${SERVER_CONTEXT}/api/get-list-student/`,
    "get-subject-by-lecturerId": `${SERVER_CONTEXT}/api/subjects/{lecturerId}/`,
    "get-list-scores": `${SERVER_CONTEXT}/api/scores/`,
    "export": `${SERVER_CONTEXT}/api/scores/export-csv/`,
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