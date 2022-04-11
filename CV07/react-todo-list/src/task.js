function Task({task, onClickHandler}){


    return (
        <div className={"task"}>
            <div className={"description"}>{task.description}</div>
            <button className={"buttonDone"} onClick={() => {
                onClickHandler(task);
            }}>DONE</button>
        </div>
    )
}

export default Task;