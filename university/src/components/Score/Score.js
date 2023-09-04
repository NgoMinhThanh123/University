import { useContext, useState } from "react";
import { MyUserContext } from "../../App";
import { authApi, endpoints } from "../../configs/Apis";
import { useEffect } from "react";

const Score = () => {
    const [user] = useContext(MyUserContext);
    const [scoreList, setScoreList] = useState([]);
    const [err, setErr] = useState("");
    const [uniqueSemesters, setUniqueSemesters] = useState({});

    useEffect(() => {
        async function fetchData() {
            try {
                const studentUsername = user.username;
                const response = await authApi().get(endpoints['get-student-by-username'].replace("{username}", studentUsername));
                const studentId = response.data.id;
                const scoreEndpoint = endpoints["score-student"] + `?studentId=${studentId}`;
                const scoreResponse = await authApi().get(scoreEndpoint);

                if (scoreResponse.data) {
                    console.log("scores:", scoreResponse.data);
                    // Lọc và duyệt danh sách điểm số
                    const filteredScores = scoreResponse.data.filter((score) => {
                        const semesterKey = `${score.semesterName} - ${score.schoolYear}`;
                        if (!uniqueSemesters[semesterKey]) {
                            setUniqueSemesters((prevUniqueSemesters) => ({
                                ...prevUniqueSemesters,
                                [semesterKey]: true,
                            }));
                            return true; // Giữ lại điểm số cho học kì và năm học chưa xuất hiện
                        }
                        return false; // Bỏ qua điểm số cho học kì và năm học đã xuất hiện
                    });
                    setScoreList(filteredScores);
                }
            } catch (err) {
                setErr(true);
            }
        }

        fetchData();
    }, [user]);

    return (
        <div>
            <h2>Thông tin điểm số</h2>
            {Object.keys(uniqueSemesters).map((semester, index) => (
                <div key={index}>
                    <h3>{semester}</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Stt</th>
                                <th>Tên môn học</th>
                                <th>Quá trình</th>
                                <th>Giữa kì</th>
                                <th>Cuối kì</th>
                                <th>Kết quả</th>
                            </tr>
                        </thead>
                        <tbody>
                            {scoreList
                                .filter((score) => `${score.semesterName} - ${score.schoolYear}` === semester)
                                .map((score, scoreIndex) => (
                                    <tr key={scoreIndex}>
                                        <td>{scoreIndex + 1}</td>
                                        <td>{score.subjectName}</td>
                                        <td>{score.scoreValue || "-"}</td>
                                        <td>{score.scoreValue || "-"}</td>
                                        <td>{score.scoreValue || "-"}</td>
                                        <td>{score.ketQua || "-"}</td>
                                    </tr>
                                ))}
                        </tbody>
                    </table>
                </div>
            ))}
        </div>
    );


}

export default Score;