function Task({task, onClickHandler}){


    return (
        <div className={"task"}>
            <div>{task.completed}
                <div className={"description"}>{task.title}</div>
                <button className={"buttonDone"} onClick={() => {
                    onClickHandler(task);
                }
                }>DONE</button>
            </div>
        </div>
    )
}

export default Task;