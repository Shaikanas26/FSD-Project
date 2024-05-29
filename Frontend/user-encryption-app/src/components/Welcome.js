import React, { useState } from 'react';
import { encryptText, decryptText } from '../services/api';
import './Welcome.css';

const Welcome = () => {
  const [inputText, setInputText] = useState('');
  const [encryptedText, setEncryptedText] = useState('');
  const [decryptedText, setDecryptedText] = useState('');
  const [message, setMessage] = useState('');

  const handleEncrypt = async () => {
    try {
      const response = await encryptText(inputText);
      setEncryptedText(response.data);
      setMessage('Text encrypted successfully');
    } catch (error) {
      const errorMessage = error.response?.data?.message || 'Encryption failed';
      setMessage(errorMessage);
      console.error(error);
    }
  };

  const handleDecrypt = async () => {
    try {
      const response = await decryptText(encryptedText);
      setDecryptedText(response.data);
      setMessage('Text decrypted successfully');
    } catch (error) {
      const errorMessage = error.response?.data?.message || 'Decryption failed';
      setMessage(errorMessage);
      console.error(error);
    }
  };

  return (
    <div className="welcome-container">
      <h2>Welcome</h2>
      <textarea
        value={inputText}
        onChange={(e) => setInputText(e.target.value)}
        placeholder="Enter text to encrypt"
      />
      <button onClick={handleEncrypt}>Encrypt</button>
      {encryptedText && (
        <>
          <h3>Encrypted Text</h3>
          <p>{encryptedText}</p>
        </>
      )}
      <button onClick={handleDecrypt}>Decrypt</button>
      {decryptedText && (
        <>
          <h3>Decrypted Text</h3>
          <p>{decryptedText}</p>
        </>
      )}
      {message && <p>{message}</p>}
    </div>
  );
};

export default Welcome;
