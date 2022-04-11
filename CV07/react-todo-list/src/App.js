import './App.css';
import Task from "./task";
import {useEffect, useState} from "react";
import TaskForm from "./task-form";
import "./todo-list.css";

function App() {

    const [data, setData] = useState([]);
    const [error, setError] = useState();
    const [page, setPage] = useState(0);



    const onNewTaskHandler = (task) => {
        const newArray = [...data];
        newArray.push(task);
        console.log(newArray);
        setData(newArray);
    }

    useEffect(() => {
        console.log("Start app")
        fetch(`${process.env.REACT_APP_TARGET_TODO_DOMAIN}/api/todos?page=${page}`)
            .then(response => {
                if (response.ok) {
                    return response.json()
                }
                throw new Error(`Unable to get data: ${response.statusText}`)
            })
            .then(json => setData(json.content))
            .catch((err) => setError(err.message))
    }, [page])

    const onRemoveTaskHandler = function (task) {
        fetch(`${process.env.REACT_APP_TARGET_TODO_DOMAIN}/api/todos/${task.id}`,{
            method: 'DELETE',
            headers: {
                'Content-type': 'application/json; charset=UTF-8',
            },
        }).then(() => json => setData(json.content))
    }

    const listItems = data.map(t => <Task key={t.id} task={t} onClickHandler={onRemoveTaskHandler}/>);

    return (
        <div className="App">
            <TaskForm onNewTask={onNewTaskHandler}/>
            <div>{listItems.reverse()}</div>
            <div className={"pageButtons"}>
                <button onClick={() => setPage(p => p - 1)}>Prev</button>
                <button>Actual page: {page}</button>
                <button onClick={() => setPage(p => p + 1)}>Next</button>
            </div>
        </div>
    );
}

export default App;
