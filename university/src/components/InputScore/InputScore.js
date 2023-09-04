import { Button, Form } from "react-bootstrap"

const InputScore = () => {
    return (
        <Form >
           
                <Form.Group>
                    <Form.Label></Form.Label>
                    <Form.Control
                        type="number"
                        
                    />
                </Form.Group>
            <Button variant="primary" >
                Lưu nháp
            </Button>
            <Button variant="success">
                Khóa điểm
            </Button>
        </Form>
    )
}

export default InputScore