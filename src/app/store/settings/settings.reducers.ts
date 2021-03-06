import {
  LOAD_NOTIFICATIONS_SETTINGS_SUCCESS,
  UPDATE_NOTIFICATIONS_SETTINGS,
  GET_BILLING_HISTORY_SUCCESS,
   GET_REF_LINKS_SUCCESS,
} from './settings.actions';
import { SettingsState } from 'models/app-state.model';
import { actions } from "store/admin/admin.actions";

const initialState: SettingsState = {
  notificationsSettings: [],
  billingHistory: {
    limit: 10,
    offset: 0,
    itemsCount: 0,
    itemsCountAll: 0,
    items: [],
  },
  refLinks: [],
};

export function settingsReducers(state = initialState, action: actions) {
  switch (action.type) {
    case LOAD_NOTIFICATIONS_SETTINGS_SUCCESS:
      return {
        ...state,
        notificationsSettings: action.payload
      };
    case UPDATE_NOTIFICATIONS_SETTINGS:
      return {
        ...state,
        notificationsSettings: action.payload
      };
    case GET_BILLING_HISTORY_SUCCESS:
      return {
        ...state,
        billingHistory: action.payload
      };
    case GET_REF_LINKS_SUCCESS:
      return {
        ...state,
        refLinks: action.payload
      };
    default:
      return state;
  }
}
