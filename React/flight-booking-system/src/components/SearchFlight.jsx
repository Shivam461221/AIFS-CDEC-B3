import React, { useState } from "react";
import axios from "axios";
import { useUser } from "../Context/UserContext";

const SearchFlight = () => {
    const [origin, setOrigin] = useState("");
    const [destination, setDestination] = useState("");
    const [departureDate, setDepartureDate] = useState("");
    const [flights, setFlights] = useState([]);
    const [error, setError] = useState("");
    const { user } = useUser();

    const handleSearch = async (e) => {
        e.preventDefault();
        setError("");
        try {
            const response = await axios.get("http://localhost:8080/api/flights/search",
                {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${user.token}`,
                    },
                    params: {
                        origin,
                        destination,
                        departureDate,
                    },
                });
            setFlights(response.data);
        } catch (err) {
            setError("No flights found or something went wrong!");
            setFlights([]);
        }
    };

    return (
        <>

            <div className="container mt-5">
                <h2 className="mb-4 text-center">Search Flights</h2>

                {/* Search Form */}
                <form onSubmit={handleSearch} className="row g-3">
                    <div className="col-md-4">
                        <label className="form-label">Origin</label>
                        <input
                            type="text"
                            className="form-control"
                            value={origin}
                            onChange={(e) => setOrigin(e.target.value)}
                            placeholder="Enter origin"
                            required
                        />
                    </div>

                    <div className="col-md-4">
                        <label className="form-label">Destination</label>
                        <input
                            type="text"
                            className="form-control"
                            value={destination}
                            onChange={(e) => setDestination(e.target.value)}
                            placeholder="Enter destination"
                            required
                        />
                    </div>

                    <div className="col-md-4">
                        <label className="form-label">Departure Date</label>
                        <input
                            type="date"
                            className="form-control"
                            value={departureDate}
                            onChange={(e) => setDepartureDate(e.target.value)}

                        />
                    </div>

                    <div className="col-12 text-center">
                        <button type="submit" className="btn btn-primary px-5">Search</button>
                    </div>
                </form>

                {/* Error Message */}
                {error && (
                    <div className="alert alert-danger mt-4" role="alert">
                        {error}
                    </div>
                )}

                {/* Flight Results */}
                {flights.length > 0 && (
                    <div className="mt-5">
                        <h4>Available Flights</h4>
                        <table className="table table-bordered table-hover mt-3">
                            <thead className="table-light">
                                <tr>
                                    <th>Flight Number</th>
                                    <th>Origin</th>
                                    <th>Destination</th>
                                    <th>Departure Date</th>
                                    <th>Arrival</th>

                                </tr>
                            </thead>
                            <tbody>
                                {flights.map((flight) => (
                                    <tr key={flight.id}>
                                        <td>{flight.flightNumber}</td>
                                        <td>{flight.origin}</td>
                                        <td>{flight.destination}</td>
                                        <td>{flight.departureDate}</td>
                                        <td>{flight.departureTime}</td>

                                    </tr>
                                ))}
                            </tbody>
                        </table>
                    </div>
                )}
            </div>
        </>
    )
};

export default SearchFlight;
