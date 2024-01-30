import React, { useEffect } from 'react';
import apiService from '../../services/apiService'; // Adjust the path accordingly

export const Home = () => {
    useEffect(() => {
        const fetchDataFromApi = () => {
            try {
                const endpoint = 'http://localhost:8989/home'; // Replace with your actual endpoint
                const requestBody = { /* your request body */ };
                const responseData = apiService.getWithoutBodyAndToken(endpoint);
                console.log('Data from API:', responseData);
            } catch (error) {
                console.error('Error:', error);
            }
        };

        fetchDataFromApi();
    }, []);

    return (
        <div>
            <p>This is the home page</p>
        </div>
    );
};
