/**
 * Created by ikka on 04.08.2015.
 */
angular.module("app")
    .constant('AUTH_EVENTS', {
      loginSuccess: 'auth-login-success',
      loginFailed: 'auth-login-failed',
      logoutSuccess: 'auth-logout-success',
      sessionTimeout: 'auth-session-timeout',
      notAuthenticated: 'auth-not-authenticated',
      notAuthorized: 'auth-not-authorized'
    })

    .constant('USER_ROLES', {
      all: '*',
      admin: 'admin',
      editor: 'editor',
      guest: 'guest'
    });

