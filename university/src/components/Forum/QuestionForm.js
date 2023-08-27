import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const QuestionForm = ({ onQuestionSubmit }) => {
  const [question, setQuestion] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (question.trim() !== '') {
      onQuestionSubmit(question);
      setQuestion('');
    }
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group controlId="question">
        <Form.Label>Ask a question:</Form.Label>
        <Form.Control
          type="text"
          placeholder="Type your question here..."
          value={question}
          onChange={(e) => setQuestion(e.target.value)}
        />
      </Form.Group>
      <Button variant="primary" type="submit">
        Submit
      </Button>
    </Form>
  );
};

export default QuestionForm;