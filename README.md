AdMob Java client
=================

Wrapping AdMob API to Java SDK.
You should edit src/test/java/admob.empty.properties and create src/test/java/admob.properties in order to run unit tests.  

### Wrapped API operations are:

* login

  * https://api.admob.com/v2/auth/login

* logout

  * https://api.admob.com/v2/auth/login

* siteSearch

  * http://api.admob.com/v2/site/search

* siteStats

  * http://api.admob.com/v2/site/stats

### How to use it

Check unit and integration tests.

### AdMob API Documentation

* http://mm.admob.com/web/pdf/AdMob_API_Documentation.pdf

### Version history

* 1.0.2.RELEASE - include maven shade plugin
* 1.0.1.RELEASE - remove runtime execptions and replace with AdMobLoginExcepiton and laeave JSONExceptions where is needed.
* 1.0.0.RELEASE - add additonal methods for mapping by object.