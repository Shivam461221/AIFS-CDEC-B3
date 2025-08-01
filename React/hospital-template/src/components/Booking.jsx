export default function Booking() {

    return <>
        <section className="book_section layout_padding">
            <div className="container">
                <div className="row">
                    <div className="col">
                        <form>
                            <h4>
                                BOOK <span>APPOINTMENT</span>
                            </h4>
                            <div className="form-row ">
                                <div className="form-group col-lg-4">
                                    <label for="inputPatientName">Patient Name </label>
                                    <input type="text" className="form-control" id="inputPatientName" placeholder="" />
                                </div>
                                <div className="form-group col-lg-4">
                                    <label for="inputDoctorName">Doctor's Name</label>
                                    <select name="" className="form-control wide" id="inputDoctorName">
                                        <option value="Normal distribution ">Normal distribution </option>
                                        <option value="Normal distribution ">Normal distribution </option>
                                        <option value="Normal distribution ">Normal distribution </option>
                                    </select>
                                </div>
                                <div className="form-group col-lg-4">
                                    <label for="inputDepartmentName">Department's Name</label>
                                    <select name="" className="form-control wide" id="inputDepartmentName">
                                        <option value="Normal distribution ">Normal distribution </option>
                                        <option value="Normal distribution ">Normal distribution </option>
                                        <option value="Normal distribution ">Normal distribution </option>
                                    </select>
                                </div>
                            </div>
                            <div className="form-row ">
                                <div className="form-group col-lg-4">
                                    <label for="inputPhone">Phone Number</label>
                                    <input type="number" className="form-control" id="inputPhone" placeholder="XXXXXXXXXX" />
                                </div>
                                <div className="form-group col-lg-4">
                                    <label for="inputSymptoms">Symptoms</label>
                                    <input type="text" className="form-control" id="inputSymptoms" placeholder="" />
                                </div>
                                <div className="form-group col-lg-4">
                                    <label for="inputDate">Choose Date </label>
                                    <div className="input-group date" id="inputDate" data-date-format="mm-dd-yyyy">
                                        <input type="text" className="form-control" readonly />
                                        <span className="input-group-addon date_icon">
                                            <i className="fa fa-calendar" aria-hidden="true"></i>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div className="btn-box">
                                <button type="submit" className="btn ">Submit Now</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </>
}