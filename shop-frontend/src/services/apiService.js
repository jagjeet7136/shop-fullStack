import axios from "axios";

const apiService = {
    getWithoutBodyAndToken: async endpoint => {
        try {
            const response = await axios.get(endpoint);
            return response.data;
        } catch (error) {
            console.error('Error fetching data:', error);
            throw error;
        }
    },

};

export default apiService;