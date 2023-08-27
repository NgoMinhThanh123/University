import React, { useState } from 'react';
import { ListGroup, Card } from 'react-bootstrap';
import QuestionForm from './QuestionForm';
import CommentForm from './CommentForm';

const QuestionList = () => {
  const [questions, setQuestions] = useState([]);

  const handleQuestionSubmit = (question) => {
    const newQuestion = {
      id: new Date().getTime(),
      content: question,
      comments: [],
    };
    setQuestions((prevQuestions) => [...prevQuestions, newQuestion]);
  };

  const handleCommentSubmit = (questionId, comment) => {
    setQuestions((prevQuestions) =>
      prevQuestions.map((q) =>
        q.id === questionId
          ? { ...q, comments: [...q.comments, comment] }
          : q
      )
    );
  };

  return (
    <div>
      <QuestionForm onQuestionSubmit={handleQuestionSubmit} />
      <Card className="mt-3">
        <Card.Header>Questions</Card.Header>
        <ListGroup variant="flush">
          {questions.map((question) => (
            <ListGroup.Item key={question.id}>
              <p>{question.content}</p>
              <CommentForm
                questionId={question.id}
                onCommentSubmit={handleCommentSubmit}
              />
              {question.comments.map((comment, index) => (
                <p key={index} className="ml-3">
                  {comment}
                </p>
              ))}
            </ListGroup.Item>
          ))}
        </ListGroup>
      </Card>
    </div>
  );
};

export default QuestionList;