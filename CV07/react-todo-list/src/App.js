import './App.css';
import Task from "./task";
import {useEffect, useState} from "react";
import TaskForm from "./task-form";
import "./todo-list.css";

function App() {

    const [data, setData] = useState([]);


    const onNewTaskHandler = (task) => {
        const newArray = [...data];
        newArray.push(task);
        console.log(newArray);
        setData(newArray);
    }

    useEffect(() => {
        console.log("Start app")
        fetch('https://jsonplaceholder.typicode.com/todos')
            .then(response => response.json())
            .then(json => {
                const sortList = json.filter(item => item.userId === 1);
                setData(sortList);
            })
    }, [])

    const onRemoveTaskHandler = function (task) {
        const newArray = [...data]
        const result = newArray.filter(t => t.id !== task.id);
        setData(result);
    }

    const listItems = data.filter(t => t.completed === false).map(t => <Task key={t.id} task={t} onClickHandler={onRemoveTaskHandler}/>);

    return (
        <div className="App">
                <TaskForm onNewTask={onNewTaskHandler}/>
            <div>{listItems.reverse()}</div>
        </div>
    );
}

export default App;
