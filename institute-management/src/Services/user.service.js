import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/test/";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getStudentBoard = () => {
  return axios.get(API_URL + "student", { headers: authHeader() });
};

const getProfBoard = () => {
  return axios.get(API_URL + "prof", { headers: authHeader() });
};

const getAdminBoard = () => {
  return axios.get(API_URL + "admin", { headers: authHeader() });
};

export default {
  getPublicContent,
  getStudentBoard,
  getProfBoard,
  getAdminBoard,
};