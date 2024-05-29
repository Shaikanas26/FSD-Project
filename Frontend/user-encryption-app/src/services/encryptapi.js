import axios from 'axios';


const ENCRYPTION_SERVICE_BASE_URL = 'http://localhost:8082';



const encryptionApi = axios.create({
  baseURL: ENCRYPTION_SERVICE_BASE_URL,
});





export const encryptText = (text) => {
  return encryptionApi.post('/encryption/encrypt', text, {
    headers: { 'Content-Type': 'text/plain' }
  });
};

export const decryptText = (text) => {
  return encryptionApi.post('/encryption/decrypt', text, {
    headers: { 'Content-Type': 'text/plain' }
  });
};
