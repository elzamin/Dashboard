import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReduser from "./projectReduser";

export default combineReducers({
  errors: errorReducer,
  project: projectReduser,
});
