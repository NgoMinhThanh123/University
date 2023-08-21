
import { useEffect, useState } from "react";
import { Alert, Container } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import MySpinner from "../../layout/MySpinner";

const Home = () => {
    const [subjects, setSubjects] = useState(null);
    useEffect(() => {
        const loadSubject = async () => {
           try {
            let e = endpoints['subjects'];

            let res = await Apis.get(e);
            setSubjects(res.data);
           } catch (ex) {
               console.error(ex);
           }
        }

        loadSubject();
    }); 

    if (subjects === null) 
        return <MySpinner />

    if (subjects.length === 0)
    return <Alert variant="info" className="mt-1">Không có giảng viên nào!</Alert>

    return (
        <>
            <h1 className="text-center text-info">DANH MỤC GIẢNG VIÊN</h1>

                
                    {subjects.map(p => {
                        return <Container>
                            <div>{p.name}</div>
                            <div>{p.credit}</div>
                        </Container>
                    })}
                

        </>
    )
}

export default Home;