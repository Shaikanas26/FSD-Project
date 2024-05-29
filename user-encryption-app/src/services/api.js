import axios from 'axios';

const USER_SERVICE_BASE_URL = 'http://localhost:8081';
const ENCRYPTION_SERVICE_BASE_URL = 'http://localhost:8082';

const userApi = axios.create({
  baseURL: USER_SERVICE_BASE_URL,
});

const encryptionApi = axios.create({
  baseURL: ENCRYPTION_SERVICE_BASE_URL,
});

export const registerUser = (userData) => {
  return userApi.post('/users/register', userData);
};

export const loginUser = (loginData) => {
  return userApi.post('/users/login', loginData);
};

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
