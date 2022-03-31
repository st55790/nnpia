import {useState} from "react";

function TaskForm(props){

    const [taskDesc, setTaskDesc] = useState("")
    const [taskCompleted, setTaskCompleted] = useState(false);
    const [count, setCount] = useState(201);

    const onSubmitHandler = event => {
        event.preventDefault();

        setCount(count+1);

        const newTask = {
            id: count,
            title: taskDesc,
            completed: taskCompleted
        }


        fetch('https://jsonplaceholder.typicode.com/todos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newTask)
        }).then(props.onNewTask(newTask));
    }

    return(
        <form onSubmit={onSubmitHandler}>
            <label>TASK DESCRIPTION</label><input id={"inputDesc"} type={"text"} value={taskDesc} onChange={(e) => setTaskDesc(e.target.value)}/>
            <input id={"inputSubmit"} type={"submit"} value={"ADD"}/>
        </form>
    )
}

export default TaskForm;