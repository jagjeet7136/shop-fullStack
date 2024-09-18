import React, { useEffect } from 'react';
import apiService from '../../services/apiService';
import { Navbar } from "../layout/Navbar";
//This is new comment

export const Home = () => {
    useEffect(() => {
        const fetchDataFromApi = async () => {
            try {
                const endpoint = 'http://localhost:8989/home';
                const requestBody = { /* your request body */ };
                const responseData = await apiService.getWithoutBodyAndToken(endpoint);
                console.log('Data from API:', responseData);
            } catch (error) {
                console.error('Error:', error);
            }
        };

        fetchDataFromApi();
    }, []);

    return (
        <Navbar />
    );
};
