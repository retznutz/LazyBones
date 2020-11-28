'use strict';
module.exports = function(app) {
  var lazyBones = require('../controllers/lazyBonesController');

  app.route('/device/on/:pinNumber')
    .get(lazyBones.on);

  app.route('/device/off/:pinNumber')
    .get(lazyBones.off);

    app.route('/device/momentary/:pinNumber')
    .get(lazyBones.momentary);

};