import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootReduser from "./reducers";

const initialState = {};
const middleware = [thunk];

let store;
const ReactReduxDevTools =
  window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__();

if (window.navigator.userAgent.includes("Chrome") && ReactReduxDevTools) {
  store = createStore(
    rootReduser,
    initialState,
    compose(applyMiddleware(...middleware), ReactReduxDevTools)
  );
} else {
  store = createStore(
    rootReduser,
    initialState,
    compose(applyMiddleware(...middleware))
  );
}

export default store;
