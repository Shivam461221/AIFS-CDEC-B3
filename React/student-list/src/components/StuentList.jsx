import { useRef, useState } from 'react';
import studentData from './StudentData';
export default function StudentList() {
    const [students, setStudents] = useState(studentData);

    const [brancheList, setBranchList] = useState(['CS', 'IT', 'CSE', 'Civil', 'EC']);

    const [branch, setBranch] = useState('All');


    const nameRef = useRef('');
    const idRef = useRef('');
    const courseRef = useRef('');
    const branchRef = useRef('');



    const add = () => {
        //let id = document.getElementById('id).value;
        let id = idRef.current.value;
        let name = nameRef.current.value;
        let course = courseRef.current.value;
        let branch = branchRef.current.value;

        if (id === '' || name === '' || course === '' || branch === '') {
            alert('All fields are mandatory');
            return;
        }
        let newStudent = { id, name, course, branch };

        setStudents([...students, newStudent]);

        idRef.current.value = '';
        nameRef.current.value = '';
        courseRef.current.value = '';
        branchRef.current.value = '';
    }

    const remove = (id) => {
        let index = students.findIndex(element => element.id === id);

        students.splice(index, 1);

        setStudents([...students]);
    }

    const filteredList = (branch=='All') ? students : students.filter(student=>student.branch==branch);

    return (
        <>
            <h1 className="display-4 text-center bg-danger p-2 text-white">Student List</h1>
            <div className="container">
                <div className="row">
                    <div className="col-md-6">
                        <div className="form-group">
                            <label htmlFor="" className="form-label">ID</label>
                            <input ref={idRef} type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="" className="form-label">Course</label>
                            <input ref={courseRef} type="text" className="form-control" />

                        </div>
                    </div>
                    <div className="col-md-6">
                        <div className="form-group">
                            <label htmlFor="" className="form-label">Name</label>
                            <input ref={nameRef} type="text" className="form-control" />
                        </div>
                        <div className="form-group">
                            <label htmlFor="" className="form-label">Branch</label>
                            {/* <input ref={branchRef} type="text" className="form-control" /> */}
                            <select className='form-control' ref={branchRef}>
                                <option value="">Select</option>
                                {
                                    brancheList.map((branch, index) => <option key={index} value={branch}>{branch}</option>)
                                }
                            </select>
                        </div>
                    </div>
                </div>
                <button onClick={() => add()} className="btn btn-primary mt-2">Add</button>
                <button onClick={()=>setBranch('All')} className="btn btn-outline-secondary m-2">All</button>
                <button onClick={()=>setBranch('CS')} className="btn btn-outline-warning m-2">CS</button>
                <button onClick={()=>setBranch('CSE')} className="btn btn-outline-danger m-2">CSE</button>
                <button onClick={()=>setBranch('IT')} className="btn btn-outline-info m-2">IT</button>
                <button onClick={()=>setBranch('Civil')} className="btn btn-outline-dark m-2">Civil</button>
            </div>
            <table className="table table-striped table-bordered mt-2">
                <thead>
                    <tr className='table-dark'>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Course</th>
                        <th>Branch</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        filteredList.map((student, index) => <tr key={index}>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>{student.course}</td>
                            <td>{student.branch}</td>
                            <td><button onClick={() => remove(student.id)} className='btn btn-outline-danger'>Remove</button></td>
                        </tr>)
                    }
                </tbody>
            </table>
        </>
    )
}