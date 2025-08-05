import React, { createContext, useContext, useState } from 'react';


const UserContext = createContext();

export const useUser = () => useContext(UserContext);


export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({
    userId: null,
    token: null,
    roles: [],
  });

  const login = ({ userId, token, roles }) => {
    setUser({ userId, token, roles });
  };

  const logout = () => {
    setUser({ userId: null, token: null, roles: [] });
  };

 

  return (
    <UserContext.Provider value={{ ...user, login, logout, user }}>
      {children}
    </UserContext.Provider>
  );
};
