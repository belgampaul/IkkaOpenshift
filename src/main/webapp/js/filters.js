/**
 * @author ikka
 * @date: 20.07.2015.
 */
angular.module('appFilters', []);

angular.module('appFilters')
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

  //todo the usage if global variables should be avoided
    .filter('base64Encoded', function () {
      return function (input) {
        return (input != null) ? Base64.encode(input) : "";
      };
    })

  //todo the usage if global variables should be avoided
    .filter('base64Decoded', function () {
      return function (input) {
        return (input != null) ? Base64.decode(input) : "";
      };
    });


angular.module('appFilters')
/**
 * just a wrapper around vkbeautify library method to make switching to another parser as easy as possible
 */
    .factory('xmlFormatter', function () {
      return {
        format: function (xmlString, step) {
          return vkbeautify.xml(xmlString, step)
        }
      };
      //return function(xmlString, step) {
      //  xml = function (xmlStirng, step) { vkbeautify.xml(xmlString, step)};
      //}
    });
