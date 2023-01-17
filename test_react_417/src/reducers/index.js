import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import projectReduser from "./projectReduser";
import backlogReducer from "./backlogReducer";
import securityReduser from "./securityReduser";

export default combineReducers({
  errors: errorReducer,
  project: projectReduser,
  backlog: backlogReducer,
  security: securityReduser,
});
