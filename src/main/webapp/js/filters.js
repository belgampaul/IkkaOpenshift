/**
 * Created by ikka on 20.07.2015.
 */
angular.module('appFilters', [])
    .filter('formattedXml', ['xmlFormatter', function (xmlFormatter) {

      return function (input, step) {
        try {
          var xmlDoc = $.parseXML(input);
          var xmlString = new XMLSerializer().serializeToString(xmlDoc);
          return xmlFormatter.format(xmlString, parseInt(step));
        } catch (e) {
          console.log(e);
          return "";
        }
      }
    }])
    .filter('base64Encoded', function () {
      return function (input) {
        return Base64.encode(input);
      };
    })
    .filter('base64Decoded', function () {
      return function (input) {
        return Base64.decode(input);
      };
    })
;

angular.module('appFilters').factory('xmlFormatter', function() {
  return {
    format : function (xmlString, step) {
      return vkbeautify.xml(xmlString, step)
    }
  };
  //return function(xmlString, step) {
  //  xml = function (xmlStirng, step) { vkbeautify.xml(xmlString, step)};
  //}
});
