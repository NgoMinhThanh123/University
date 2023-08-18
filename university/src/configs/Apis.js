import axios from "axios";

const SERVER_CONTEXT = "/University";
const SERVER = "http://localhost:8080";

export const endpoints = {
    "subject": `${SERVER_CONTEXT}/api/subjects/`,

}


export default axios.create({
    baseURL: SERVER
})