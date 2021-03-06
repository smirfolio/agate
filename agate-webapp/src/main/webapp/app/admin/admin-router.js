/*
 * Copyright (c) 2019 OBiBa. All rights reserved.
 *
 * This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

'use strict';

agate.admin

  .config(['$routeProvider',
    function ($routeProvider) {
      $routeProvider
        .when('/admin', {
          templateUrl: 'app/admin/views/admin-view.html',
          controller: 'AdminViewController',
          access: {
            authorizedRoles: ['agate-administrator']
          }
        });
    }]);
