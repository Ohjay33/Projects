import React from "react";


// Basic setup for a functional component
// const Form = ()=>{}

const Form = ()=>{
    return(
        <>
        <h3>Find Your Player</h3>
        <form>
                <label>Player Name</label>
            <div className="form-group">
                <input type="text" className="form-control" />
            </div>
            <br />
                <label>Team Name</label>
            <div className="form-group">
                <input type="text" className="form-control" />
            </div>
            <br />
                <label>Position</label>
            <div className="form-group">
                <input type="text" className="form-control" />
            </div>
            <br />
                <label>Image</label>
            <div className="form-group">
                <input type="text" className="form-control" />
            </div>
            <br />
            <button>Search </button>
        </form>
        </>

    )
}



export default Form;