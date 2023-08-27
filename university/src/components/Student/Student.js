import { Button, Form } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../../configs/Apis";
import { useContext, useEffect, useState } from "react";
import { MyUserContext } from "../../App";

const Student = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [subjectList, setSubjectList] = useState([]); // Danh sách các môn học (danh sách các tên)
    const [selectedSubject, setSelectedSubject] = useState(""); // Môn học được chọn
    const [selectedSubjectInfo, setSelectedSubjectInfo] = useState({}); // Thông tin chi tiết của môn học được chọn
    const [selectedLecturer, setSelectedLecturer] = useState({});
    const [err, setErr] = useState("");

    useEffect(() => {
        async function fetchData() {
            try {
                const lecturerInfo = await fetchLecturerInfo();
                if (lecturerInfo && lecturerInfo.id) {
                    const lecturerId = lecturerInfo.id;
                    await fetchSubjectsByLecturerId(lecturerId);
                }
            } catch (err) {
                setErr(true);
            }
        }

        fetchData();
    }, []);

    const fetchLecturerInfo = async () => {
        try {
            const lecturerUsername = user.username;
            const response = await authApi().get(endpoints['get-lecturer-by-username'].replace("{username}", lecturerUsername));
            setSelectedLecturer(response.data);
            console.log('lecturer info:', response.data);
            return response.data;
        } catch (err) {
            setErr(true);
            return null;
        }
    }

    const fetchSubjectsByLecturerId = async (lecturerId) => {
        try {
            const response = await authApi().get(endpoints["get-subject-by-lecturerId"].replace("{lecturereId}", lecturerId));
            setSubjectList(response.data.map(subject => subject[0])); // Lấy danh sách các tên môn học
            console.log(subjectList);
        } catch (error) {
            console.error(error);
            console.log(error);
            return null;
        }
    }

    const handleSubjectChange = async (event) => {
        const selectedSubjectName = event.target.value;
        setSelectedSubject(selectedSubjectName);

        try {
            const response = await authApi().get(endpoints["get-subject-by-lecturerId"].replace("{lecturereId}", selectedSubjectName));
            setSelectedSubjectInfo(response.data[0]); // Lấy thông tin chi tiết của môn học được chọn
            console.log(response.data);
        } catch (error) {
            console.error(error);
            console.log(error);
            return null;
        }
    };

    const handleSubmit = (event) => {
        event.preventDefault();
        // Handle form submission if needed
    };


    return (
        <>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="subjectSelect">
                    <Form.Label>Chọn môn học:</Form.Label>
                    <Form.Control as="select" onChange={handleSubjectChange} value={selectedSubject}>
                        <option value="">Chọn môn học</option>
                        {subjectList.map((subjectName, index) => (
                            <option key={index} value={subjectName}>{subjectName}</option>
                        ))}
                    </Form.Control>
                </Form.Group>
                <Button type="submit">Submit</Button>
            </Form>
            <div>
                <h2>Thông tin môn học:</h2>
                <p>Tên môn học: {selectedSubjectInfo.name}</p>
                <p>Số tín chỉ: {selectedSubjectInfo.credit}</p>
                {/* Hiển thị các thông tin khác của môn học ở đây */}
            </div>
        </>
    );
};

export default Student;






