import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReduser from "./projectReduser";
import backlogReducer from "./backlogReducer";

export default combineReducers({
  errors: errorReducer,
  project: projectReduser,
  backlog: backlogReducer,
});
