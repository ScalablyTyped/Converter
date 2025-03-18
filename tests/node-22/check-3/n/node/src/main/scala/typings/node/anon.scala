package typings.node

import org.scalablytyped.runtime.StObject
import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobalScope, JSGlobal, JSImport, JSName, JSBracketAccess}

object anon {
  
  trait Typeofconstants extends StObject {
    
    val errno: Typeoferrno
  }
  object Typeofconstants {
    
    inline def apply(errno: Typeoferrno): Typeofconstants = {
      val __obj = js.Dynamic.literal(errno = errno.asInstanceOf[js.Any])
      __obj.asInstanceOf[Typeofconstants]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Typeofconstants] (val x: Self) extends AnyVal {
      
      inline def setErrno(value: Typeoferrno): Self = StObject.set(x, "errno", value.asInstanceOf[js.Any])
    }
  }
  
  trait TypeofconstantsErrno extends StObject {
    
    val errno: TypeoferrnoDEFAULTSETTINGSENABLEPUSH
  }
  object TypeofconstantsErrno {
    
    inline def apply(errno: TypeoferrnoDEFAULTSETTINGSENABLEPUSH): TypeofconstantsErrno = {
      val __obj = js.Dynamic.literal(errno = errno.asInstanceOf[js.Any])
      __obj.asInstanceOf[TypeofconstantsErrno]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: TypeofconstantsErrno] (val x: Self) extends AnyVal {
      
      inline def setErrno(value: TypeoferrnoDEFAULTSETTINGSENABLEPUSH): Self = StObject.set(x, "errno", value.asInstanceOf[js.Any])
    }
  }
  
  trait Typeoferrno extends StObject {
    
    val E2BIG: Double
    
    val EACCES: Double
    
    val EADDRINUSE: Double
    
    val EADDRNOTAVAIL: Double
    
    val EAFNOSUPPORT: Double
    
    val EAGAIN: Double
    
    val EALREADY: Double
    
    val EBADF: Double
    
    val EBADMSG: Double
    
    val EBUSY: Double
    
    val ECANCELED: Double
    
    val ECHILD: Double
    
    val ECONNABORTED: Double
    
    val ECONNREFUSED: Double
    
    val ECONNRESET: Double
    
    val EDEADLK: Double
    
    val EDESTADDRREQ: Double
    
    val EDOM: Double
    
    val EDQUOT: Double
    
    val EEXIST: Double
    
    val EFAULT: Double
    
    val EFBIG: Double
    
    val EHOSTUNREACH: Double
    
    val EIDRM: Double
    
    val EILSEQ: Double
    
    val EINPROGRESS: Double
    
    val EINTR: Double
    
    val EINVAL: Double
    
    val EIO: Double
    
    val EISCONN: Double
    
    val EISDIR: Double
    
    val ELOOP: Double
    
    val EMFILE: Double
    
    val EMLINK: Double
    
    val EMSGSIZE: Double
    
    val EMULTIHOP: Double
    
    val ENAMETOOLONG: Double
    
    val ENETDOWN: Double
    
    val ENETRESET: Double
    
    val ENETUNREACH: Double
    
    val ENFILE: Double
    
    val ENOBUFS: Double
    
    val ENODATA: Double
    
    val ENODEV: Double
    
    val ENOENT: Double
    
    val ENOEXEC: Double
    
    val ENOLCK: Double
    
    val ENOLINK: Double
    
    val ENOMEM: Double
    
    val ENOMSG: Double
    
    val ENOPROTOOPT: Double
    
    val ENOSPC: Double
    
    val ENOSR: Double
    
    val ENOSTR: Double
    
    val ENOSYS: Double
    
    val ENOTCONN: Double
    
    val ENOTDIR: Double
    
    val ENOTEMPTY: Double
    
    val ENOTSOCK: Double
    
    val ENOTSUP: Double
    
    val ENOTTY: Double
    
    val ENXIO: Double
    
    val EOPNOTSUPP: Double
    
    val EOVERFLOW: Double
    
    val EPERM: Double
    
    val EPIPE: Double
    
    val EPROTO: Double
    
    val EPROTONOSUPPORT: Double
    
    val EPROTOTYPE: Double
    
    val ERANGE: Double
    
    val EROFS: Double
    
    val ESPIPE: Double
    
    val ESRCH: Double
    
    val ESTALE: Double
    
    val ETIME: Double
    
    val ETIMEDOUT: Double
    
    val ETXTBSY: Double
    
    val EWOULDBLOCK: Double
    
    val EXDEV: Double
    
    val WSAEACCES: Double
    
    val WSAEADDRINUSE: Double
    
    val WSAEADDRNOTAVAIL: Double
    
    val WSAEAFNOSUPPORT: Double
    
    val WSAEALREADY: Double
    
    val WSAEBADF: Double
    
    val WSAECANCELLED: Double
    
    val WSAECONNABORTED: Double
    
    val WSAECONNREFUSED: Double
    
    val WSAECONNRESET: Double
    
    val WSAEDESTADDRREQ: Double
    
    val WSAEDISCON: Double
    
    val WSAEDQUOT: Double
    
    val WSAEFAULT: Double
    
    val WSAEHOSTDOWN: Double
    
    val WSAEHOSTUNREACH: Double
    
    val WSAEINPROGRESS: Double
    
    val WSAEINTR: Double
    
    val WSAEINVAL: Double
    
    val WSAEINVALIDPROCTABLE: Double
    
    val WSAEINVALIDPROVIDER: Double
    
    val WSAEISCONN: Double
    
    val WSAELOOP: Double
    
    val WSAEMFILE: Double
    
    val WSAEMSGSIZE: Double
    
    val WSAENAMETOOLONG: Double
    
    val WSAENETDOWN: Double
    
    val WSAENETRESET: Double
    
    val WSAENETUNREACH: Double
    
    val WSAENOBUFS: Double
    
    val WSAENOMORE: Double
    
    val WSAENOPROTOOPT: Double
    
    val WSAENOTCONN: Double
    
    val WSAENOTEMPTY: Double
    
    val WSAENOTSOCK: Double
    
    val WSAEOPNOTSUPP: Double
    
    val WSAEPFNOSUPPORT: Double
    
    val WSAEPROCLIM: Double
    
    val WSAEPROTONOSUPPORT: Double
    
    val WSAEPROTOTYPE: Double
    
    val WSAEPROVIDERFAILEDINIT: Double
    
    val WSAEREFUSED: Double
    
    val WSAEREMOTE: Double
    
    val WSAESHUTDOWN: Double
    
    val WSAESOCKTNOSUPPORT: Double
    
    val WSAESTALE: Double
    
    val WSAETIMEDOUT: Double
    
    val WSAETOOMANYREFS: Double
    
    val WSAEUSERS: Double
    
    val WSAEWOULDBLOCK: Double
    
    val WSANOTINITIALISED: Double
    
    val WSASERVICE_NOT_FOUND: Double
    
    val WSASYSCALLFAILURE: Double
    
    val WSASYSNOTREADY: Double
    
    val WSATYPE_NOT_FOUND: Double
    
    val WSAVERNOTSUPPORTED: Double
    
    val WSA_E_CANCELLED: Double
    
    val WSA_E_NO_MORE: Double
  }
  object Typeoferrno {
    
    inline def apply(
      E2BIG: Double,
      EACCES: Double,
      EADDRINUSE: Double,
      EADDRNOTAVAIL: Double,
      EAFNOSUPPORT: Double,
      EAGAIN: Double,
      EALREADY: Double,
      EBADF: Double,
      EBADMSG: Double,
      EBUSY: Double,
      ECANCELED: Double,
      ECHILD: Double,
      ECONNABORTED: Double,
      ECONNREFUSED: Double,
      ECONNRESET: Double,
      EDEADLK: Double,
      EDESTADDRREQ: Double,
      EDOM: Double,
      EDQUOT: Double,
      EEXIST: Double,
      EFAULT: Double,
      EFBIG: Double,
      EHOSTUNREACH: Double,
      EIDRM: Double,
      EILSEQ: Double,
      EINPROGRESS: Double,
      EINTR: Double,
      EINVAL: Double,
      EIO: Double,
      EISCONN: Double,
      EISDIR: Double,
      ELOOP: Double,
      EMFILE: Double,
      EMLINK: Double,
      EMSGSIZE: Double,
      EMULTIHOP: Double,
      ENAMETOOLONG: Double,
      ENETDOWN: Double,
      ENETRESET: Double,
      ENETUNREACH: Double,
      ENFILE: Double,
      ENOBUFS: Double,
      ENODATA: Double,
      ENODEV: Double,
      ENOENT: Double,
      ENOEXEC: Double,
      ENOLCK: Double,
      ENOLINK: Double,
      ENOMEM: Double,
      ENOMSG: Double,
      ENOPROTOOPT: Double,
      ENOSPC: Double,
      ENOSR: Double,
      ENOSTR: Double,
      ENOSYS: Double,
      ENOTCONN: Double,
      ENOTDIR: Double,
      ENOTEMPTY: Double,
      ENOTSOCK: Double,
      ENOTSUP: Double,
      ENOTTY: Double,
      ENXIO: Double,
      EOPNOTSUPP: Double,
      EOVERFLOW: Double,
      EPERM: Double,
      EPIPE: Double,
      EPROTO: Double,
      EPROTONOSUPPORT: Double,
      EPROTOTYPE: Double,
      ERANGE: Double,
      EROFS: Double,
      ESPIPE: Double,
      ESRCH: Double,
      ESTALE: Double,
      ETIME: Double,
      ETIMEDOUT: Double,
      ETXTBSY: Double,
      EWOULDBLOCK: Double,
      EXDEV: Double,
      WSAEACCES: Double,
      WSAEADDRINUSE: Double,
      WSAEADDRNOTAVAIL: Double,
      WSAEAFNOSUPPORT: Double,
      WSAEALREADY: Double,
      WSAEBADF: Double,
      WSAECANCELLED: Double,
      WSAECONNABORTED: Double,
      WSAECONNREFUSED: Double,
      WSAECONNRESET: Double,
      WSAEDESTADDRREQ: Double,
      WSAEDISCON: Double,
      WSAEDQUOT: Double,
      WSAEFAULT: Double,
      WSAEHOSTDOWN: Double,
      WSAEHOSTUNREACH: Double,
      WSAEINPROGRESS: Double,
      WSAEINTR: Double,
      WSAEINVAL: Double,
      WSAEINVALIDPROCTABLE: Double,
      WSAEINVALIDPROVIDER: Double,
      WSAEISCONN: Double,
      WSAELOOP: Double,
      WSAEMFILE: Double,
      WSAEMSGSIZE: Double,
      WSAENAMETOOLONG: Double,
      WSAENETDOWN: Double,
      WSAENETRESET: Double,
      WSAENETUNREACH: Double,
      WSAENOBUFS: Double,
      WSAENOMORE: Double,
      WSAENOPROTOOPT: Double,
      WSAENOTCONN: Double,
      WSAENOTEMPTY: Double,
      WSAENOTSOCK: Double,
      WSAEOPNOTSUPP: Double,
      WSAEPFNOSUPPORT: Double,
      WSAEPROCLIM: Double,
      WSAEPROTONOSUPPORT: Double,
      WSAEPROTOTYPE: Double,
      WSAEPROVIDERFAILEDINIT: Double,
      WSAEREFUSED: Double,
      WSAEREMOTE: Double,
      WSAESHUTDOWN: Double,
      WSAESOCKTNOSUPPORT: Double,
      WSAESTALE: Double,
      WSAETIMEDOUT: Double,
      WSAETOOMANYREFS: Double
    ): Typeoferrno = {
      val __obj = js.Dynamic.literal(E2BIG = E2BIG.asInstanceOf[js.Any], EACCES = EACCES.asInstanceOf[js.Any], EADDRINUSE = EADDRINUSE.asInstanceOf[js.Any], EADDRNOTAVAIL = EADDRNOTAVAIL.asInstanceOf[js.Any], EAFNOSUPPORT = EAFNOSUPPORT.asInstanceOf[js.Any], EAGAIN = EAGAIN.asInstanceOf[js.Any], EALREADY = EALREADY.asInstanceOf[js.Any], EBADF = EBADF.asInstanceOf[js.Any], EBADMSG = EBADMSG.asInstanceOf[js.Any], EBUSY = EBUSY.asInstanceOf[js.Any], ECANCELED = ECANCELED.asInstanceOf[js.Any], ECHILD = ECHILD.asInstanceOf[js.Any], ECONNABORTED = ECONNABORTED.asInstanceOf[js.Any], ECONNREFUSED = ECONNREFUSED.asInstanceOf[js.Any], ECONNRESET = ECONNRESET.asInstanceOf[js.Any], EDEADLK = EDEADLK.asInstanceOf[js.Any], EDESTADDRREQ = EDESTADDRREQ.asInstanceOf[js.Any], EDOM = EDOM.asInstanceOf[js.Any], EDQUOT = EDQUOT.asInstanceOf[js.Any], EEXIST = EEXIST.asInstanceOf[js.Any], EFAULT = EFAULT.asInstanceOf[js.Any], EFBIG = EFBIG.asInstanceOf[js.Any], EHOSTUNREACH = EHOSTUNREACH.asInstanceOf[js.Any], EIDRM = EIDRM.asInstanceOf[js.Any], EILSEQ = EILSEQ.asInstanceOf[js.Any], EINPROGRESS = EINPROGRESS.asInstanceOf[js.Any], EINTR = EINTR.asInstanceOf[js.Any], EINVAL = EINVAL.asInstanceOf[js.Any], EIO = EIO.asInstanceOf[js.Any], EISCONN = EISCONN.asInstanceOf[js.Any], EISDIR = EISDIR.asInstanceOf[js.Any], ELOOP = ELOOP.asInstanceOf[js.Any], EMFILE = EMFILE.asInstanceOf[js.Any], EMLINK = EMLINK.asInstanceOf[js.Any], EMSGSIZE = EMSGSIZE.asInstanceOf[js.Any], EMULTIHOP = EMULTIHOP.asInstanceOf[js.Any], ENAMETOOLONG = ENAMETOOLONG.asInstanceOf[js.Any], ENETDOWN = ENETDOWN.asInstanceOf[js.Any], ENETRESET = ENETRESET.asInstanceOf[js.Any], ENETUNREACH = ENETUNREACH.asInstanceOf[js.Any], ENFILE = ENFILE.asInstanceOf[js.Any], ENOBUFS = ENOBUFS.asInstanceOf[js.Any], ENODATA = ENODATA.asInstanceOf[js.Any], ENODEV = ENODEV.asInstanceOf[js.Any], ENOENT = ENOENT.asInstanceOf[js.Any], ENOEXEC = ENOEXEC.asInstanceOf[js.Any], ENOLCK = ENOLCK.asInstanceOf[js.Any], ENOLINK = ENOLINK.asInstanceOf[js.Any], ENOMEM = ENOMEM.asInstanceOf[js.Any], ENOMSG = ENOMSG.asInstanceOf[js.Any], ENOPROTOOPT = ENOPROTOOPT.asInstanceOf[js.Any], ENOSPC = ENOSPC.asInstanceOf[js.Any], ENOSR = ENOSR.asInstanceOf[js.Any], ENOSTR = ENOSTR.asInstanceOf[js.Any], ENOSYS = ENOSYS.asInstanceOf[js.Any], ENOTCONN = ENOTCONN.asInstanceOf[js.Any], ENOTDIR = ENOTDIR.asInstanceOf[js.Any], ENOTEMPTY = ENOTEMPTY.asInstanceOf[js.Any], ENOTSOCK = ENOTSOCK.asInstanceOf[js.Any], ENOTSUP = ENOTSUP.asInstanceOf[js.Any], ENOTTY = ENOTTY.asInstanceOf[js.Any], ENXIO = ENXIO.asInstanceOf[js.Any], EOPNOTSUPP = EOPNOTSUPP.asInstanceOf[js.Any], EOVERFLOW = EOVERFLOW.asInstanceOf[js.Any], EPERM = EPERM.asInstanceOf[js.Any], EPIPE = EPIPE.asInstanceOf[js.Any], EPROTO = EPROTO.asInstanceOf[js.Any], EPROTONOSUPPORT = EPROTONOSUPPORT.asInstanceOf[js.Any], EPROTOTYPE = EPROTOTYPE.asInstanceOf[js.Any], ERANGE = ERANGE.asInstanceOf[js.Any], EROFS = EROFS.asInstanceOf[js.Any], ESPIPE = ESPIPE.asInstanceOf[js.Any], ESRCH = ESRCH.asInstanceOf[js.Any], ESTALE = ESTALE.asInstanceOf[js.Any], ETIME = ETIME.asInstanceOf[js.Any], ETIMEDOUT = ETIMEDOUT.asInstanceOf[js.Any], ETXTBSY = ETXTBSY.asInstanceOf[js.Any], EWOULDBLOCK = EWOULDBLOCK.asInstanceOf[js.Any], EXDEV = EXDEV.asInstanceOf[js.Any], WSAEACCES = WSAEACCES.asInstanceOf[js.Any], WSAEADDRINUSE = WSAEADDRINUSE.asInstanceOf[js.Any], WSAEADDRNOTAVAIL = WSAEADDRNOTAVAIL.asInstanceOf[js.Any], WSAEAFNOSUPPORT = WSAEAFNOSUPPORT.asInstanceOf[js.Any], WSAEALREADY = WSAEALREADY.asInstanceOf[js.Any], WSAEBADF = WSAEBADF.asInstanceOf[js.Any], WSAECANCELLED = WSAECANCELLED.asInstanceOf[js.Any], WSAECONNABORTED = WSAECONNABORTED.asInstanceOf[js.Any], WSAECONNREFUSED = WSAECONNREFUSED.asInstanceOf[js.Any], WSAECONNRESET = WSAECONNRESET.asInstanceOf[js.Any], WSAEDESTADDRREQ = WSAEDESTADDRREQ.asInstanceOf[js.Any], WSAEDISCON = WSAEDISCON.asInstanceOf[js.Any], WSAEDQUOT = WSAEDQUOT.asInstanceOf[js.Any], WSAEFAULT = WSAEFAULT.asInstanceOf[js.Any], WSAEHOSTDOWN = WSAEHOSTDOWN.asInstanceOf[js.Any], WSAEHOSTUNREACH = WSAEHOSTUNREACH.asInstanceOf[js.Any], WSAEINPROGRESS = WSAEINPROGRESS.asInstanceOf[js.Any], WSAEINTR = WSAEINTR.asInstanceOf[js.Any], WSAEINVAL = WSAEINVAL.asInstanceOf[js.Any], WSAEINVALIDPROCTABLE = WSAEINVALIDPROCTABLE.asInstanceOf[js.Any], WSAEINVALIDPROVIDER = WSAEINVALIDPROVIDER.asInstanceOf[js.Any], WSAEISCONN = WSAEISCONN.asInstanceOf[js.Any], WSAELOOP = WSAELOOP.asInstanceOf[js.Any], WSAEMFILE = WSAEMFILE.asInstanceOf[js.Any], WSAEMSGSIZE = WSAEMSGSIZE.asInstanceOf[js.Any], WSAENAMETOOLONG = WSAENAMETOOLONG.asInstanceOf[js.Any], WSAENETDOWN = WSAENETDOWN.asInstanceOf[js.Any], WSAENETRESET = WSAENETRESET.asInstanceOf[js.Any], WSAENETUNREACH = WSAENETUNREACH.asInstanceOf[js.Any], WSAENOBUFS = WSAENOBUFS.asInstanceOf[js.Any], WSAENOMORE = WSAENOMORE.asInstanceOf[js.Any], WSAENOPROTOOPT = WSAENOPROTOOPT.asInstanceOf[js.Any], WSAENOTCONN = WSAENOTCONN.asInstanceOf[js.Any], WSAENOTEMPTY = WSAENOTEMPTY.asInstanceOf[js.Any], WSAENOTSOCK = WSAENOTSOCK.asInstanceOf[js.Any], WSAEOPNOTSUPP = WSAEOPNOTSUPP.asInstanceOf[js.Any], WSAEPFNOSUPPORT = WSAEPFNOSUPPORT.asInstanceOf[js.Any], WSAEPROCLIM = WSAEPROCLIM.asInstanceOf[js.Any], WSAEPROTONOSUPPORT = WSAEPROTONOSUPPORT.asInstanceOf[js.Any], WSAEPROTOTYPE = WSAEPROTOTYPE.asInstanceOf[js.Any], WSAEPROVIDERFAILEDINIT = WSAEPROVIDERFAILEDINIT.asInstanceOf[js.Any], WSAEREFUSED = WSAEREFUSED.asInstanceOf[js.Any], WSAEREMOTE = WSAEREMOTE.asInstanceOf[js.Any], WSAESHUTDOWN = WSAESHUTDOWN.asInstanceOf[js.Any], WSAESOCKTNOSUPPORT = WSAESOCKTNOSUPPORT.asInstanceOf[js.Any], WSAESTALE = WSAESTALE.asInstanceOf[js.Any], WSAETIMEDOUT = WSAETIMEDOUT.asInstanceOf[js.Any], WSAETOOMANYREFS = WSAETOOMANYREFS.asInstanceOf[js.Any])
      __obj.asInstanceOf[Typeoferrno]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: Typeoferrno] (val x: Self) extends AnyVal {
      
      inline def setE2BIG(value: Double): Self = StObject.set(x, "E2BIG", value.asInstanceOf[js.Any])
      
      inline def setEACCES(value: Double): Self = StObject.set(x, "EACCES", value.asInstanceOf[js.Any])
      
      inline def setEADDRINUSE(value: Double): Self = StObject.set(x, "EADDRINUSE", value.asInstanceOf[js.Any])
      
      inline def setEADDRNOTAVAIL(value: Double): Self = StObject.set(x, "EADDRNOTAVAIL", value.asInstanceOf[js.Any])
      
      inline def setEAFNOSUPPORT(value: Double): Self = StObject.set(x, "EAFNOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setEAGAIN(value: Double): Self = StObject.set(x, "EAGAIN", value.asInstanceOf[js.Any])
      
      inline def setEALREADY(value: Double): Self = StObject.set(x, "EALREADY", value.asInstanceOf[js.Any])
      
      inline def setEBADF(value: Double): Self = StObject.set(x, "EBADF", value.asInstanceOf[js.Any])
      
      inline def setEBADMSG(value: Double): Self = StObject.set(x, "EBADMSG", value.asInstanceOf[js.Any])
      
      inline def setEBUSY(value: Double): Self = StObject.set(x, "EBUSY", value.asInstanceOf[js.Any])
      
      inline def setECANCELED(value: Double): Self = StObject.set(x, "ECANCELED", value.asInstanceOf[js.Any])
      
      inline def setECHILD(value: Double): Self = StObject.set(x, "ECHILD", value.asInstanceOf[js.Any])
      
      inline def setECONNABORTED(value: Double): Self = StObject.set(x, "ECONNABORTED", value.asInstanceOf[js.Any])
      
      inline def setECONNREFUSED(value: Double): Self = StObject.set(x, "ECONNREFUSED", value.asInstanceOf[js.Any])
      
      inline def setECONNRESET(value: Double): Self = StObject.set(x, "ECONNRESET", value.asInstanceOf[js.Any])
      
      inline def setEDEADLK(value: Double): Self = StObject.set(x, "EDEADLK", value.asInstanceOf[js.Any])
      
      inline def setEDESTADDRREQ(value: Double): Self = StObject.set(x, "EDESTADDRREQ", value.asInstanceOf[js.Any])
      
      inline def setEDOM(value: Double): Self = StObject.set(x, "EDOM", value.asInstanceOf[js.Any])
      
      inline def setEDQUOT(value: Double): Self = StObject.set(x, "EDQUOT", value.asInstanceOf[js.Any])
      
      inline def setEEXIST(value: Double): Self = StObject.set(x, "EEXIST", value.asInstanceOf[js.Any])
      
      inline def setEFAULT(value: Double): Self = StObject.set(x, "EFAULT", value.asInstanceOf[js.Any])
      
      inline def setEFBIG(value: Double): Self = StObject.set(x, "EFBIG", value.asInstanceOf[js.Any])
      
      inline def setEHOSTUNREACH(value: Double): Self = StObject.set(x, "EHOSTUNREACH", value.asInstanceOf[js.Any])
      
      inline def setEIDRM(value: Double): Self = StObject.set(x, "EIDRM", value.asInstanceOf[js.Any])
      
      inline def setEILSEQ(value: Double): Self = StObject.set(x, "EILSEQ", value.asInstanceOf[js.Any])
      
      inline def setEINPROGRESS(value: Double): Self = StObject.set(x, "EINPROGRESS", value.asInstanceOf[js.Any])
      
      inline def setEINTR(value: Double): Self = StObject.set(x, "EINTR", value.asInstanceOf[js.Any])
      
      inline def setEINVAL(value: Double): Self = StObject.set(x, "EINVAL", value.asInstanceOf[js.Any])
      
      inline def setEIO(value: Double): Self = StObject.set(x, "EIO", value.asInstanceOf[js.Any])
      
      inline def setEISCONN(value: Double): Self = StObject.set(x, "EISCONN", value.asInstanceOf[js.Any])
      
      inline def setEISDIR(value: Double): Self = StObject.set(x, "EISDIR", value.asInstanceOf[js.Any])
      
      inline def setELOOP(value: Double): Self = StObject.set(x, "ELOOP", value.asInstanceOf[js.Any])
      
      inline def setEMFILE(value: Double): Self = StObject.set(x, "EMFILE", value.asInstanceOf[js.Any])
      
      inline def setEMLINK(value: Double): Self = StObject.set(x, "EMLINK", value.asInstanceOf[js.Any])
      
      inline def setEMSGSIZE(value: Double): Self = StObject.set(x, "EMSGSIZE", value.asInstanceOf[js.Any])
      
      inline def setEMULTIHOP(value: Double): Self = StObject.set(x, "EMULTIHOP", value.asInstanceOf[js.Any])
      
      inline def setENAMETOOLONG(value: Double): Self = StObject.set(x, "ENAMETOOLONG", value.asInstanceOf[js.Any])
      
      inline def setENETDOWN(value: Double): Self = StObject.set(x, "ENETDOWN", value.asInstanceOf[js.Any])
      
      inline def setENETRESET(value: Double): Self = StObject.set(x, "ENETRESET", value.asInstanceOf[js.Any])
      
      inline def setENETUNREACH(value: Double): Self = StObject.set(x, "ENETUNREACH", value.asInstanceOf[js.Any])
      
      inline def setENFILE(value: Double): Self = StObject.set(x, "ENFILE", value.asInstanceOf[js.Any])
      
      inline def setENOBUFS(value: Double): Self = StObject.set(x, "ENOBUFS", value.asInstanceOf[js.Any])
      
      inline def setENODATA(value: Double): Self = StObject.set(x, "ENODATA", value.asInstanceOf[js.Any])
      
      inline def setENODEV(value: Double): Self = StObject.set(x, "ENODEV", value.asInstanceOf[js.Any])
      
      inline def setENOENT(value: Double): Self = StObject.set(x, "ENOENT", value.asInstanceOf[js.Any])
      
      inline def setENOEXEC(value: Double): Self = StObject.set(x, "ENOEXEC", value.asInstanceOf[js.Any])
      
      inline def setENOLCK(value: Double): Self = StObject.set(x, "ENOLCK", value.asInstanceOf[js.Any])
      
      inline def setENOLINK(value: Double): Self = StObject.set(x, "ENOLINK", value.asInstanceOf[js.Any])
      
      inline def setENOMEM(value: Double): Self = StObject.set(x, "ENOMEM", value.asInstanceOf[js.Any])
      
      inline def setENOMSG(value: Double): Self = StObject.set(x, "ENOMSG", value.asInstanceOf[js.Any])
      
      inline def setENOPROTOOPT(value: Double): Self = StObject.set(x, "ENOPROTOOPT", value.asInstanceOf[js.Any])
      
      inline def setENOSPC(value: Double): Self = StObject.set(x, "ENOSPC", value.asInstanceOf[js.Any])
      
      inline def setENOSR(value: Double): Self = StObject.set(x, "ENOSR", value.asInstanceOf[js.Any])
      
      inline def setENOSTR(value: Double): Self = StObject.set(x, "ENOSTR", value.asInstanceOf[js.Any])
      
      inline def setENOSYS(value: Double): Self = StObject.set(x, "ENOSYS", value.asInstanceOf[js.Any])
      
      inline def setENOTCONN(value: Double): Self = StObject.set(x, "ENOTCONN", value.asInstanceOf[js.Any])
      
      inline def setENOTDIR(value: Double): Self = StObject.set(x, "ENOTDIR", value.asInstanceOf[js.Any])
      
      inline def setENOTEMPTY(value: Double): Self = StObject.set(x, "ENOTEMPTY", value.asInstanceOf[js.Any])
      
      inline def setENOTSOCK(value: Double): Self = StObject.set(x, "ENOTSOCK", value.asInstanceOf[js.Any])
      
      inline def setENOTSUP(value: Double): Self = StObject.set(x, "ENOTSUP", value.asInstanceOf[js.Any])
      
      inline def setENOTTY(value: Double): Self = StObject.set(x, "ENOTTY", value.asInstanceOf[js.Any])
      
      inline def setENXIO(value: Double): Self = StObject.set(x, "ENXIO", value.asInstanceOf[js.Any])
      
      inline def setEOPNOTSUPP(value: Double): Self = StObject.set(x, "EOPNOTSUPP", value.asInstanceOf[js.Any])
      
      inline def setEOVERFLOW(value: Double): Self = StObject.set(x, "EOVERFLOW", value.asInstanceOf[js.Any])
      
      inline def setEPERM(value: Double): Self = StObject.set(x, "EPERM", value.asInstanceOf[js.Any])
      
      inline def setEPIPE(value: Double): Self = StObject.set(x, "EPIPE", value.asInstanceOf[js.Any])
      
      inline def setEPROTO(value: Double): Self = StObject.set(x, "EPROTO", value.asInstanceOf[js.Any])
      
      inline def setEPROTONOSUPPORT(value: Double): Self = StObject.set(x, "EPROTONOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setEPROTOTYPE(value: Double): Self = StObject.set(x, "EPROTOTYPE", value.asInstanceOf[js.Any])
      
      inline def setERANGE(value: Double): Self = StObject.set(x, "ERANGE", value.asInstanceOf[js.Any])
      
      inline def setEROFS(value: Double): Self = StObject.set(x, "EROFS", value.asInstanceOf[js.Any])
      
      inline def setESPIPE(value: Double): Self = StObject.set(x, "ESPIPE", value.asInstanceOf[js.Any])
      
      inline def setESRCH(value: Double): Self = StObject.set(x, "ESRCH", value.asInstanceOf[js.Any])
      
      inline def setESTALE(value: Double): Self = StObject.set(x, "ESTALE", value.asInstanceOf[js.Any])
      
      inline def setETIME(value: Double): Self = StObject.set(x, "ETIME", value.asInstanceOf[js.Any])
      
      inline def setETIMEDOUT(value: Double): Self = StObject.set(x, "ETIMEDOUT", value.asInstanceOf[js.Any])
      
      inline def setETXTBSY(value: Double): Self = StObject.set(x, "ETXTBSY", value.asInstanceOf[js.Any])
      
      inline def setEWOULDBLOCK(value: Double): Self = StObject.set(x, "EWOULDBLOCK", value.asInstanceOf[js.Any])
      
      inline def setEXDEV(value: Double): Self = StObject.set(x, "EXDEV", value.asInstanceOf[js.Any])
      
      inline def setWSAEACCES(value: Double): Self = StObject.set(x, "WSAEACCES", value.asInstanceOf[js.Any])
      
      inline def setWSAEADDRINUSE(value: Double): Self = StObject.set(x, "WSAEADDRINUSE", value.asInstanceOf[js.Any])
      
      inline def setWSAEADDRNOTAVAIL(value: Double): Self = StObject.set(x, "WSAEADDRNOTAVAIL", value.asInstanceOf[js.Any])
      
      inline def setWSAEAFNOSUPPORT(value: Double): Self = StObject.set(x, "WSAEAFNOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setWSAEALREADY(value: Double): Self = StObject.set(x, "WSAEALREADY", value.asInstanceOf[js.Any])
      
      inline def setWSAEBADF(value: Double): Self = StObject.set(x, "WSAEBADF", value.asInstanceOf[js.Any])
      
      inline def setWSAECANCELLED(value: Double): Self = StObject.set(x, "WSAECANCELLED", value.asInstanceOf[js.Any])
      
      inline def setWSAECONNABORTED(value: Double): Self = StObject.set(x, "WSAECONNABORTED", value.asInstanceOf[js.Any])
      
      inline def setWSAECONNREFUSED(value: Double): Self = StObject.set(x, "WSAECONNREFUSED", value.asInstanceOf[js.Any])
      
      inline def setWSAECONNRESET(value: Double): Self = StObject.set(x, "WSAECONNRESET", value.asInstanceOf[js.Any])
      
      inline def setWSAEDESTADDRREQ(value: Double): Self = StObject.set(x, "WSAEDESTADDRREQ", value.asInstanceOf[js.Any])
      
      inline def setWSAEDISCON(value: Double): Self = StObject.set(x, "WSAEDISCON", value.asInstanceOf[js.Any])
      
      inline def setWSAEDQUOT(value: Double): Self = StObject.set(x, "WSAEDQUOT", value.asInstanceOf[js.Any])
      
      inline def setWSAEFAULT(value: Double): Self = StObject.set(x, "WSAEFAULT", value.asInstanceOf[js.Any])
      
      inline def setWSAEHOSTDOWN(value: Double): Self = StObject.set(x, "WSAEHOSTDOWN", value.asInstanceOf[js.Any])
      
      inline def setWSAEHOSTUNREACH(value: Double): Self = StObject.set(x, "WSAEHOSTUNREACH", value.asInstanceOf[js.Any])
      
      inline def setWSAEINPROGRESS(value: Double): Self = StObject.set(x, "WSAEINPROGRESS", value.asInstanceOf[js.Any])
      
      inline def setWSAEINTR(value: Double): Self = StObject.set(x, "WSAEINTR", value.asInstanceOf[js.Any])
      
      inline def setWSAEINVAL(value: Double): Self = StObject.set(x, "WSAEINVAL", value.asInstanceOf[js.Any])
      
      inline def setWSAEINVALIDPROCTABLE(value: Double): Self = StObject.set(x, "WSAEINVALIDPROCTABLE", value.asInstanceOf[js.Any])
      
      inline def setWSAEINVALIDPROVIDER(value: Double): Self = StObject.set(x, "WSAEINVALIDPROVIDER", value.asInstanceOf[js.Any])
      
      inline def setWSAEISCONN(value: Double): Self = StObject.set(x, "WSAEISCONN", value.asInstanceOf[js.Any])
      
      inline def setWSAELOOP(value: Double): Self = StObject.set(x, "WSAELOOP", value.asInstanceOf[js.Any])
      
      inline def setWSAEMFILE(value: Double): Self = StObject.set(x, "WSAEMFILE", value.asInstanceOf[js.Any])
      
      inline def setWSAEMSGSIZE(value: Double): Self = StObject.set(x, "WSAEMSGSIZE", value.asInstanceOf[js.Any])
      
      inline def setWSAENAMETOOLONG(value: Double): Self = StObject.set(x, "WSAENAMETOOLONG", value.asInstanceOf[js.Any])
      
      inline def setWSAENETDOWN(value: Double): Self = StObject.set(x, "WSAENETDOWN", value.asInstanceOf[js.Any])
      
      inline def setWSAENETRESET(value: Double): Self = StObject.set(x, "WSAENETRESET", value.asInstanceOf[js.Any])
      
      inline def setWSAENETUNREACH(value: Double): Self = StObject.set(x, "WSAENETUNREACH", value.asInstanceOf[js.Any])
      
      inline def setWSAENOBUFS(value: Double): Self = StObject.set(x, "WSAENOBUFS", value.asInstanceOf[js.Any])
      
      inline def setWSAENOMORE(value: Double): Self = StObject.set(x, "WSAENOMORE", value.asInstanceOf[js.Any])
      
      inline def setWSAENOPROTOOPT(value: Double): Self = StObject.set(x, "WSAENOPROTOOPT", value.asInstanceOf[js.Any])
      
      inline def setWSAENOTCONN(value: Double): Self = StObject.set(x, "WSAENOTCONN", value.asInstanceOf[js.Any])
      
      inline def setWSAENOTEMPTY(value: Double): Self = StObject.set(x, "WSAENOTEMPTY", value.asInstanceOf[js.Any])
      
      inline def setWSAENOTSOCK(value: Double): Self = StObject.set(x, "WSAENOTSOCK", value.asInstanceOf[js.Any])
      
      inline def setWSAEOPNOTSUPP(value: Double): Self = StObject.set(x, "WSAEOPNOTSUPP", value.asInstanceOf[js.Any])
      
      inline def setWSAEPFNOSUPPORT(value: Double): Self = StObject.set(x, "WSAEPFNOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setWSAEPROCLIM(value: Double): Self = StObject.set(x, "WSAEPROCLIM", value.asInstanceOf[js.Any])
      
      inline def setWSAEPROTONOSUPPORT(value: Double): Self = StObject.set(x, "WSAEPROTONOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setWSAEPROTOTYPE(value: Double): Self = StObject.set(x, "WSAEPROTOTYPE", value.asInstanceOf[js.Any])
      
      inline def setWSAEPROVIDERFAILEDINIT(value: Double): Self = StObject.set(x, "WSAEPROVIDERFAILEDINIT", value.asInstanceOf[js.Any])
      
      inline def setWSAEREFUSED(value: Double): Self = StObject.set(x, "WSAEREFUSED", value.asInstanceOf[js.Any])
      
      inline def setWSAEREMOTE(value: Double): Self = StObject.set(x, "WSAEREMOTE", value.asInstanceOf[js.Any])
      
      inline def setWSAESHUTDOWN(value: Double): Self = StObject.set(x, "WSAESHUTDOWN", value.asInstanceOf[js.Any])
      
      inline def setWSAESOCKTNOSUPPORT(value: Double): Self = StObject.set(x, "WSAESOCKTNOSUPPORT", value.asInstanceOf[js.Any])
      
      inline def setWSAESTALE(value: Double): Self = StObject.set(x, "WSAESTALE", value.asInstanceOf[js.Any])
      
      inline def setWSAETIMEDOUT(value: Double): Self = StObject.set(x, "WSAETIMEDOUT", value.asInstanceOf[js.Any])
      
      inline def setWSAETOOMANYREFS(value: Double): Self = StObject.set(x, "WSAETOOMANYREFS", value.asInstanceOf[js.Any])
      
      inline def setWSAEUSERS(value: Double): Self = StObject.set(x, "WSAEUSERS", value.asInstanceOf[js.Any])
      
      inline def setWSAEWOULDBLOCK(value: Double): Self = StObject.set(x, "WSAEWOULDBLOCK", value.asInstanceOf[js.Any])
      
      inline def setWSANOTINITIALISED(value: Double): Self = StObject.set(x, "WSANOTINITIALISED", value.asInstanceOf[js.Any])
      
      inline def setWSASERVICE_NOT_FOUND(value: Double): Self = StObject.set(x, "WSASERVICE_NOT_FOUND", value.asInstanceOf[js.Any])
      
      inline def setWSASYSCALLFAILURE(value: Double): Self = StObject.set(x, "WSASYSCALLFAILURE", value.asInstanceOf[js.Any])
      
      inline def setWSASYSNOTREADY(value: Double): Self = StObject.set(x, "WSASYSNOTREADY", value.asInstanceOf[js.Any])
      
      inline def setWSATYPE_NOT_FOUND(value: Double): Self = StObject.set(x, "WSATYPE_NOT_FOUND", value.asInstanceOf[js.Any])
      
      inline def setWSAVERNOTSUPPORTED(value: Double): Self = StObject.set(x, "WSAVERNOTSUPPORTED", value.asInstanceOf[js.Any])
      
      inline def setWSA_E_CANCELLED(value: Double): Self = StObject.set(x, "WSA_E_CANCELLED", value.asInstanceOf[js.Any])
      
      inline def setWSA_E_NO_MORE(value: Double): Self = StObject.set(x, "WSA_E_NO_MORE", value.asInstanceOf[js.Any])
    }
  }
  
  trait TypeoferrnoDEFAULTSETTINGSENABLEPUSH extends StObject {
    
    val DEFAULT_SETTINGS_ENABLE_PUSH: Double
    
    val DEFAULT_SETTINGS_HEADER_TABLE_SIZE: Double
    
    val DEFAULT_SETTINGS_INITIAL_WINDOW_SIZE: Double
    
    val DEFAULT_SETTINGS_MAX_FRAME_SIZE: Double
    
    val HTTP2_HEADER_ACCEPT: String
    
    val HTTP2_HEADER_ACCEPT_CHARSET: String
    
    val HTTP2_HEADER_ACCEPT_ENCODING: String
    
    val HTTP2_HEADER_ACCEPT_LANGUAGE: String
    
    val HTTP2_HEADER_ACCEPT_RANGES: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS: String
    
    val HTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD: String
    
    val HTTP2_HEADER_AGE: String
    
    val HTTP2_HEADER_ALLOW: String
    
    val HTTP2_HEADER_AUTHORITY: String
    
    val HTTP2_HEADER_AUTHORIZATION: String
    
    val HTTP2_HEADER_CACHE_CONTROL: String
    
    val HTTP2_HEADER_CONNECTION: String
    
    val HTTP2_HEADER_CONTENT_DISPOSITION: String
    
    val HTTP2_HEADER_CONTENT_ENCODING: String
    
    val HTTP2_HEADER_CONTENT_LANGUAGE: String
    
    val HTTP2_HEADER_CONTENT_LENGTH: String
    
    val HTTP2_HEADER_CONTENT_LOCATION: String
    
    val HTTP2_HEADER_CONTENT_MD5: String
    
    val HTTP2_HEADER_CONTENT_RANGE: String
    
    val HTTP2_HEADER_CONTENT_TYPE: String
    
    val HTTP2_HEADER_COOKIE: String
    
    val HTTP2_HEADER_DATE: String
    
    val HTTP2_HEADER_ETAG: String
    
    val HTTP2_HEADER_EXPECT: String
    
    val HTTP2_HEADER_EXPIRES: String
    
    val HTTP2_HEADER_FROM: String
    
    val HTTP2_HEADER_HOST: String
    
    val HTTP2_HEADER_HTTP2_SETTINGS: String
    
    val HTTP2_HEADER_IF_MATCH: String
    
    val HTTP2_HEADER_IF_MODIFIED_SINCE: String
    
    val HTTP2_HEADER_IF_NONE_MATCH: String
    
    val HTTP2_HEADER_IF_RANGE: String
    
    val HTTP2_HEADER_IF_UNMODIFIED_SINCE: String
    
    val HTTP2_HEADER_KEEP_ALIVE: String
    
    val HTTP2_HEADER_LAST_MODIFIED: String
    
    val HTTP2_HEADER_LINK: String
    
    val HTTP2_HEADER_LOCATION: String
    
    val HTTP2_HEADER_MAX_FORWARDS: String
    
    val HTTP2_HEADER_METHOD: String
    
    val HTTP2_HEADER_PATH: String
    
    val HTTP2_HEADER_PREFER: String
    
    val HTTP2_HEADER_PROXY_AUTHENTICATE: String
    
    val HTTP2_HEADER_PROXY_AUTHORIZATION: String
    
    val HTTP2_HEADER_PROXY_CONNECTION: String
    
    val HTTP2_HEADER_RANGE: String
    
    val HTTP2_HEADER_REFERER: String
    
    val HTTP2_HEADER_REFRESH: String
    
    val HTTP2_HEADER_RETRY_AFTER: String
    
    val HTTP2_HEADER_SCHEME: String
    
    val HTTP2_HEADER_SERVER: String
    
    val HTTP2_HEADER_SET_COOKIE: String
    
    val HTTP2_HEADER_STATUS: String
    
    val HTTP2_HEADER_STRICT_TRANSPORT_SECURITY: String
    
    val HTTP2_HEADER_TE: String
    
    val HTTP2_HEADER_TRANSFER_ENCODING: String
    
    val HTTP2_HEADER_UPGRADE: String
    
    val HTTP2_HEADER_USER_AGENT: String
    
    val HTTP2_HEADER_VARY: String
    
    val HTTP2_HEADER_VIA: String
    
    val HTTP2_HEADER_WWW_AUTHENTICATE: String
    
    val HTTP2_METHOD_ACL: String
    
    val HTTP2_METHOD_BASELINE_CONTROL: String
    
    val HTTP2_METHOD_BIND: String
    
    val HTTP2_METHOD_CHECKIN: String
    
    val HTTP2_METHOD_CHECKOUT: String
    
    val HTTP2_METHOD_CONNECT: String
    
    val HTTP2_METHOD_COPY: String
    
    val HTTP2_METHOD_DELETE: String
    
    val HTTP2_METHOD_GET: String
    
    val HTTP2_METHOD_HEAD: String
    
    val HTTP2_METHOD_LABEL: String
    
    val HTTP2_METHOD_LINK: String
    
    val HTTP2_METHOD_LOCK: String
    
    val HTTP2_METHOD_MERGE: String
    
    val HTTP2_METHOD_MKACTIVITY: String
    
    val HTTP2_METHOD_MKCALENDAR: String
    
    val HTTP2_METHOD_MKCOL: String
    
    val HTTP2_METHOD_MKREDIRECTREF: String
    
    val HTTP2_METHOD_MKWORKSPACE: String
    
    val HTTP2_METHOD_MOVE: String
    
    val HTTP2_METHOD_OPTIONS: String
    
    val HTTP2_METHOD_ORDERPATCH: String
    
    val HTTP2_METHOD_PATCH: String
    
    val HTTP2_METHOD_POST: String
    
    val HTTP2_METHOD_PRI: String
    
    val HTTP2_METHOD_PROPFIND: String
    
    val HTTP2_METHOD_PROPPATCH: String
    
    val HTTP2_METHOD_PUT: String
    
    val HTTP2_METHOD_REBIND: String
    
    val HTTP2_METHOD_REPORT: String
    
    val HTTP2_METHOD_SEARCH: String
    
    val HTTP2_METHOD_TRACE: String
    
    val HTTP2_METHOD_UNBIND: String
    
    val HTTP2_METHOD_UNCHECKOUT: String
    
    val HTTP2_METHOD_UNLINK: String
    
    val HTTP2_METHOD_UNLOCK: String
    
    val HTTP2_METHOD_UPDATE: String
    
    val HTTP2_METHOD_UPDATEREDIRECTREF: String
    
    val HTTP2_METHOD_VERSION_CONTROL: String
    
    val HTTP_STATUS_ACCEPTED: Double
    
    val HTTP_STATUS_ALREADY_REPORTED: Double
    
    val HTTP_STATUS_BAD_GATEWAY: Double
    
    val HTTP_STATUS_BAD_REQUEST: Double
    
    val HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED: Double
    
    val HTTP_STATUS_CONFLICT: Double
    
    val HTTP_STATUS_CONTINUE: Double
    
    val HTTP_STATUS_CREATED: Double
    
    val HTTP_STATUS_EXPECTATION_FAILED: Double
    
    val HTTP_STATUS_FAILED_DEPENDENCY: Double
    
    val HTTP_STATUS_FORBIDDEN: Double
    
    val HTTP_STATUS_FOUND: Double
    
    val HTTP_STATUS_GATEWAY_TIMEOUT: Double
    
    val HTTP_STATUS_GONE: Double
    
    val HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED: Double
    
    val HTTP_STATUS_IM_USED: Double
    
    val HTTP_STATUS_INSUFFICIENT_STORAGE: Double
    
    val HTTP_STATUS_INTERNAL_SERVER_ERROR: Double
    
    val HTTP_STATUS_LENGTH_REQUIRED: Double
    
    val HTTP_STATUS_LOCKED: Double
    
    val HTTP_STATUS_LOOP_DETECTED: Double
    
    val HTTP_STATUS_METHOD_NOT_ALLOWED: Double
    
    val HTTP_STATUS_MISDIRECTED_REQUEST: Double
    
    val HTTP_STATUS_MOVED_PERMANENTLY: Double
    
    val HTTP_STATUS_MULTIPLE_CHOICES: Double
    
    val HTTP_STATUS_MULTI_STATUS: Double
    
    val HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED: Double
    
    val HTTP_STATUS_NON_AUTHORITATIVE_INFORMATION: Double
    
    val HTTP_STATUS_NOT_ACCEPTABLE: Double
    
    val HTTP_STATUS_NOT_EXTENDED: Double
    
    val HTTP_STATUS_NOT_FOUND: Double
    
    val HTTP_STATUS_NOT_IMPLEMENTED: Double
    
    val HTTP_STATUS_NOT_MODIFIED: Double
    
    val HTTP_STATUS_NO_CONTENT: Double
    
    val HTTP_STATUS_OK: Double
    
    val HTTP_STATUS_PARTIAL_CONTENT: Double
    
    val HTTP_STATUS_PAYLOAD_TOO_LARGE: Double
    
    val HTTP_STATUS_PAYMENT_REQUIRED: Double
    
    val HTTP_STATUS_PERMANENT_REDIRECT: Double
    
    val HTTP_STATUS_PRECONDITION_FAILED: Double
    
    val HTTP_STATUS_PRECONDITION_REQUIRED: Double
    
    val HTTP_STATUS_PROCESSING: Double
    
    val HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED: Double
    
    val HTTP_STATUS_RANGE_NOT_SATISFIABLE: Double
    
    val HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE: Double
    
    val HTTP_STATUS_REQUEST_TIMEOUT: Double
    
    val HTTP_STATUS_RESET_CONTENT: Double
    
    val HTTP_STATUS_SEE_OTHER: Double
    
    val HTTP_STATUS_SERVICE_UNAVAILABLE: Double
    
    val HTTP_STATUS_SWITCHING_PROTOCOLS: Double
    
    val HTTP_STATUS_TEAPOT: Double
    
    val HTTP_STATUS_TEMPORARY_REDIRECT: Double
    
    val HTTP_STATUS_TOO_MANY_REQUESTS: Double
    
    val HTTP_STATUS_UNAUTHORIZED: Double
    
    val HTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS: Double
    
    val HTTP_STATUS_UNORDERED_COLLECTION: Double
    
    val HTTP_STATUS_UNPROCESSABLE_ENTITY: Double
    
    val HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE: Double
    
    val HTTP_STATUS_UPGRADE_REQUIRED: Double
    
    val HTTP_STATUS_URI_TOO_LONG: Double
    
    val HTTP_STATUS_USE_PROXY: Double
    
    val HTTP_STATUS_VARIANT_ALSO_NEGOTIATES: Double
    
    val MAX_INITIAL_WINDOW_SIZE: Double
    
    val MAX_MAX_FRAME_SIZE: Double
    
    val MIN_MAX_FRAME_SIZE: Double
    
    val NGHTTP2_CANCEL: Double
    
    val NGHTTP2_COMPRESSION_ERROR: Double
    
    val NGHTTP2_CONNECT_ERROR: Double
    
    val NGHTTP2_DEFAULT_WEIGHT: Double
    
    val NGHTTP2_ENHANCE_YOUR_CALM: Double
    
    val NGHTTP2_ERR_FRAME_SIZE_ERROR: Double
    
    val NGHTTP2_FLAG_ACK: Double
    
    val NGHTTP2_FLAG_END_HEADERS: Double
    
    val NGHTTP2_FLAG_END_STREAM: Double
    
    val NGHTTP2_FLAG_NONE: Double
    
    val NGHTTP2_FLAG_PADDED: Double
    
    val NGHTTP2_FLAG_PRIORITY: Double
    
    val NGHTTP2_FLOW_CONTROL_ERROR: Double
    
    val NGHTTP2_FRAME_SIZE_ERROR: Double
    
    val NGHTTP2_HTTP_1_1_REQUIRED: Double
    
    val NGHTTP2_INADEQUATE_SECURITY: Double
    
    val NGHTTP2_INTERNAL_ERROR: Double
    
    val NGHTTP2_NO_ERROR: Double
    
    val NGHTTP2_PROTOCOL_ERROR: Double
    
    val NGHTTP2_REFUSED_STREAM: Double
    
    val NGHTTP2_SESSION_CLIENT: Double
    
    val NGHTTP2_SESSION_SERVER: Double
    
    val NGHTTP2_SETTINGS_ENABLE_PUSH: Double
    
    val NGHTTP2_SETTINGS_HEADER_TABLE_SIZE: Double
    
    val NGHTTP2_SETTINGS_INITIAL_WINDOW_SIZE: Double
    
    val NGHTTP2_SETTINGS_MAX_CONCURRENT_STREAMS: Double
    
    val NGHTTP2_SETTINGS_MAX_FRAME_SIZE: Double
    
    val NGHTTP2_SETTINGS_MAX_HEADER_LIST_SIZE: Double
    
    val NGHTTP2_SETTINGS_TIMEOUT: Double
    
    val NGHTTP2_STREAM_CLOSED: Double
    
    val NGHTTP2_STREAM_STATE_CLOSED: Double
    
    val NGHTTP2_STREAM_STATE_HALF_CLOSED_LOCAL: Double
    
    val NGHTTP2_STREAM_STATE_HALF_CLOSED_REMOTE: Double
    
    val NGHTTP2_STREAM_STATE_IDLE: Double
    
    val NGHTTP2_STREAM_STATE_OPEN: Double
    
    val NGHTTP2_STREAM_STATE_RESERVED_LOCAL: Double
    
    val NGHTTP2_STREAM_STATE_RESERVED_REMOTE: Double
    
    val PADDING_STRATEGY_CALLBACK: Double
    
    val PADDING_STRATEGY_MAX: Double
    
    val PADDING_STRATEGY_NONE: Double
  }
  object TypeoferrnoDEFAULTSETTINGSENABLEPUSH {
    
    inline def apply(
      DEFAULT_SETTINGS_ENABLE_PUSH: Double,
      DEFAULT_SETTINGS_HEADER_TABLE_SIZE: Double,
      DEFAULT_SETTINGS_INITIAL_WINDOW_SIZE: Double,
      DEFAULT_SETTINGS_MAX_FRAME_SIZE: Double,
      HTTP2_HEADER_ACCEPT: String,
      HTTP2_HEADER_ACCEPT_CHARSET: String,
      HTTP2_HEADER_ACCEPT_ENCODING: String,
      HTTP2_HEADER_ACCEPT_LANGUAGE: String,
      HTTP2_HEADER_ACCEPT_RANGES: String,
      HTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS: String,
      HTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS: String,
      HTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS: String,
      HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN: String,
      HTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS: String,
      HTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS: String,
      HTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD: String,
      HTTP2_HEADER_AGE: String,
      HTTP2_HEADER_ALLOW: String,
      HTTP2_HEADER_AUTHORITY: String,
      HTTP2_HEADER_AUTHORIZATION: String,
      HTTP2_HEADER_CACHE_CONTROL: String,
      HTTP2_HEADER_CONNECTION: String,
      HTTP2_HEADER_CONTENT_DISPOSITION: String,
      HTTP2_HEADER_CONTENT_ENCODING: String,
      HTTP2_HEADER_CONTENT_LANGUAGE: String,
      HTTP2_HEADER_CONTENT_LENGTH: String,
      HTTP2_HEADER_CONTENT_LOCATION: String,
      HTTP2_HEADER_CONTENT_MD5: String,
      HTTP2_HEADER_CONTENT_RANGE: String,
      HTTP2_HEADER_CONTENT_TYPE: String,
      HTTP2_HEADER_COOKIE: String,
      HTTP2_HEADER_DATE: String,
      HTTP2_HEADER_ETAG: String,
      HTTP2_HEADER_EXPECT: String,
      HTTP2_HEADER_EXPIRES: String,
      HTTP2_HEADER_FROM: String,
      HTTP2_HEADER_HOST: String,
      HTTP2_HEADER_HTTP2_SETTINGS: String,
      HTTP2_HEADER_IF_MATCH: String,
      HTTP2_HEADER_IF_MODIFIED_SINCE: String,
      HTTP2_HEADER_IF_NONE_MATCH: String,
      HTTP2_HEADER_IF_RANGE: String,
      HTTP2_HEADER_IF_UNMODIFIED_SINCE: String,
      HTTP2_HEADER_KEEP_ALIVE: String,
      HTTP2_HEADER_LAST_MODIFIED: String,
      HTTP2_HEADER_LINK: String,
      HTTP2_HEADER_LOCATION: String,
      HTTP2_HEADER_MAX_FORWARDS: String,
      HTTP2_HEADER_METHOD: String,
      HTTP2_HEADER_PATH: String,
      HTTP2_HEADER_PREFER: String,
      HTTP2_HEADER_PROXY_AUTHENTICATE: String,
      HTTP2_HEADER_PROXY_AUTHORIZATION: String,
      HTTP2_HEADER_PROXY_CONNECTION: String,
      HTTP2_HEADER_RANGE: String,
      HTTP2_HEADER_REFERER: String,
      HTTP2_HEADER_REFRESH: String,
      HTTP2_HEADER_RETRY_AFTER: String,
      HTTP2_HEADER_SCHEME: String,
      HTTP2_HEADER_SERVER: String,
      HTTP2_HEADER_SET_COOKIE: String,
      HTTP2_HEADER_STATUS: String,
      HTTP2_HEADER_STRICT_TRANSPORT_SECURITY: String,
      HTTP2_HEADER_TE: String,
      HTTP2_HEADER_TRANSFER_ENCODING: String,
      HTTP2_HEADER_UPGRADE: String,
      HTTP2_HEADER_USER_AGENT: String,
      HTTP2_HEADER_VARY: String,
      HTTP2_HEADER_VIA: String,
      HTTP2_HEADER_WWW_AUTHENTICATE: String,
      HTTP2_METHOD_ACL: String,
      HTTP2_METHOD_BASELINE_CONTROL: String,
      HTTP2_METHOD_BIND: String,
      HTTP2_METHOD_CHECKIN: String,
      HTTP2_METHOD_CHECKOUT: String,
      HTTP2_METHOD_CONNECT: String,
      HTTP2_METHOD_COPY: String,
      HTTP2_METHOD_DELETE: String,
      HTTP2_METHOD_GET: String,
      HTTP2_METHOD_HEAD: String,
      HTTP2_METHOD_LABEL: String,
      HTTP2_METHOD_LINK: String,
      HTTP2_METHOD_LOCK: String,
      HTTP2_METHOD_MERGE: String,
      HTTP2_METHOD_MKACTIVITY: String,
      HTTP2_METHOD_MKCALENDAR: String,
      HTTP2_METHOD_MKCOL: String,
      HTTP2_METHOD_MKREDIRECTREF: String,
      HTTP2_METHOD_MKWORKSPACE: String,
      HTTP2_METHOD_MOVE: String,
      HTTP2_METHOD_OPTIONS: String,
      HTTP2_METHOD_ORDERPATCH: String,
      HTTP2_METHOD_PATCH: String,
      HTTP2_METHOD_POST: String,
      HTTP2_METHOD_PRI: String,
      HTTP2_METHOD_PROPFIND: String,
      HTTP2_METHOD_PROPPATCH: String,
      HTTP2_METHOD_PUT: String,
      HTTP2_METHOD_REBIND: String,
      HTTP2_METHOD_REPORT: String,
      HTTP2_METHOD_SEARCH: String,
      HTTP2_METHOD_TRACE: String,
      HTTP2_METHOD_UNBIND: String,
      HTTP2_METHOD_UNCHECKOUT: String,
      HTTP2_METHOD_UNLINK: String,
      HTTP2_METHOD_UNLOCK: String,
      HTTP2_METHOD_UPDATE: String,
      HTTP2_METHOD_UPDATEREDIRECTREF: String,
      HTTP2_METHOD_VERSION_CONTROL: String,
      HTTP_STATUS_ACCEPTED: Double,
      HTTP_STATUS_ALREADY_REPORTED: Double,
      HTTP_STATUS_BAD_GATEWAY: Double,
      HTTP_STATUS_BAD_REQUEST: Double,
      HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED: Double,
      HTTP_STATUS_CONFLICT: Double,
      HTTP_STATUS_CONTINUE: Double,
      HTTP_STATUS_CREATED: Double,
      HTTP_STATUS_EXPECTATION_FAILED: Double,
      HTTP_STATUS_FAILED_DEPENDENCY: Double,
      HTTP_STATUS_FORBIDDEN: Double,
      HTTP_STATUS_FOUND: Double,
      HTTP_STATUS_GATEWAY_TIMEOUT: Double,
      HTTP_STATUS_GONE: Double,
      HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED: Double,
      HTTP_STATUS_IM_USED: Double,
      HTTP_STATUS_INSUFFICIENT_STORAGE: Double,
      HTTP_STATUS_INTERNAL_SERVER_ERROR: Double,
      HTTP_STATUS_LENGTH_REQUIRED: Double,
      HTTP_STATUS_LOCKED: Double,
      HTTP_STATUS_LOOP_DETECTED: Double,
      HTTP_STATUS_METHOD_NOT_ALLOWED: Double,
      HTTP_STATUS_MISDIRECTED_REQUEST: Double,
      HTTP_STATUS_MOVED_PERMANENTLY: Double,
      HTTP_STATUS_MULTIPLE_CHOICES: Double,
      HTTP_STATUS_MULTI_STATUS: Double,
      HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED: Double,
      HTTP_STATUS_NON_AUTHORITATIVE_INFORMATION: Double,
      HTTP_STATUS_NOT_ACCEPTABLE: Double,
      HTTP_STATUS_NOT_EXTENDED: Double,
      HTTP_STATUS_NOT_FOUND: Double,
      HTTP_STATUS_NOT_IMPLEMENTED: Double,
      HTTP_STATUS_NOT_MODIFIED: Double,
      HTTP_STATUS_NO_CONTENT: Double,
      HTTP_STATUS_OK: Double,
      HTTP_STATUS_PARTIAL_CONTENT: Double,
      HTTP_STATUS_PAYLOAD_TOO_LARGE: Double,
      HTTP_STATUS_PAYMENT_REQUIRED: Double,
      HTTP_STATUS_PERMANENT_REDIRECT: Double,
      HTTP_STATUS_PRECONDITION_FAILED: Double,
      HTTP_STATUS_PRECONDITION_REQUIRED: Double,
      HTTP_STATUS_PROCESSING: Double,
      HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED: Double,
      HTTP_STATUS_RANGE_NOT_SATISFIABLE: Double,
      HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE: Double,
      HTTP_STATUS_REQUEST_TIMEOUT: Double,
      HTTP_STATUS_RESET_CONTENT: Double,
      HTTP_STATUS_SEE_OTHER: Double,
      HTTP_STATUS_SERVICE_UNAVAILABLE: Double,
      HTTP_STATUS_SWITCHING_PROTOCOLS: Double,
      HTTP_STATUS_TEAPOT: Double,
      HTTP_STATUS_TEMPORARY_REDIRECT: Double,
      HTTP_STATUS_TOO_MANY_REQUESTS: Double,
      HTTP_STATUS_UNAUTHORIZED: Double,
      HTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS: Double,
      HTTP_STATUS_UNORDERED_COLLECTION: Double,
      HTTP_STATUS_UNPROCESSABLE_ENTITY: Double,
      HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE: Double,
      HTTP_STATUS_UPGRADE_REQUIRED: Double,
      HTTP_STATUS_URI_TOO_LONG: Double,
      HTTP_STATUS_USE_PROXY: Double,
      HTTP_STATUS_VARIANT_ALSO_NEGOTIATES: Double,
      MAX_INITIAL_WINDOW_SIZE: Double,
      MAX_MAX_FRAME_SIZE: Double,
      MIN_MAX_FRAME_SIZE: Double,
      NGHTTP2_CANCEL: Double,
      NGHTTP2_COMPRESSION_ERROR: Double,
      NGHTTP2_CONNECT_ERROR: Double,
      NGHTTP2_DEFAULT_WEIGHT: Double,
      NGHTTP2_ENHANCE_YOUR_CALM: Double
    ): TypeoferrnoDEFAULTSETTINGSENABLEPUSH = {
      val __obj = js.Dynamic.literal(DEFAULT_SETTINGS_ENABLE_PUSH = DEFAULT_SETTINGS_ENABLE_PUSH.asInstanceOf[js.Any], DEFAULT_SETTINGS_HEADER_TABLE_SIZE = DEFAULT_SETTINGS_HEADER_TABLE_SIZE.asInstanceOf[js.Any], DEFAULT_SETTINGS_INITIAL_WINDOW_SIZE = DEFAULT_SETTINGS_INITIAL_WINDOW_SIZE.asInstanceOf[js.Any], DEFAULT_SETTINGS_MAX_FRAME_SIZE = DEFAULT_SETTINGS_MAX_FRAME_SIZE.asInstanceOf[js.Any], HTTP2_HEADER_ACCEPT = HTTP2_HEADER_ACCEPT.asInstanceOf[js.Any], HTTP2_HEADER_ACCEPT_CHARSET = HTTP2_HEADER_ACCEPT_CHARSET.asInstanceOf[js.Any], HTTP2_HEADER_ACCEPT_ENCODING = HTTP2_HEADER_ACCEPT_ENCODING.asInstanceOf[js.Any], HTTP2_HEADER_ACCEPT_LANGUAGE = HTTP2_HEADER_ACCEPT_LANGUAGE.asInstanceOf[js.Any], HTTP2_HEADER_ACCEPT_RANGES = HTTP2_HEADER_ACCEPT_RANGES.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = HTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS = HTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS = HTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS = HTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS = HTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS.asInstanceOf[js.Any], HTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD = HTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD.asInstanceOf[js.Any], HTTP2_HEADER_AGE = HTTP2_HEADER_AGE.asInstanceOf[js.Any], HTTP2_HEADER_ALLOW = HTTP2_HEADER_ALLOW.asInstanceOf[js.Any], HTTP2_HEADER_AUTHORITY = HTTP2_HEADER_AUTHORITY.asInstanceOf[js.Any], HTTP2_HEADER_AUTHORIZATION = HTTP2_HEADER_AUTHORIZATION.asInstanceOf[js.Any], HTTP2_HEADER_CACHE_CONTROL = HTTP2_HEADER_CACHE_CONTROL.asInstanceOf[js.Any], HTTP2_HEADER_CONNECTION = HTTP2_HEADER_CONNECTION.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_DISPOSITION = HTTP2_HEADER_CONTENT_DISPOSITION.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_ENCODING = HTTP2_HEADER_CONTENT_ENCODING.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_LANGUAGE = HTTP2_HEADER_CONTENT_LANGUAGE.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_LENGTH = HTTP2_HEADER_CONTENT_LENGTH.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_LOCATION = HTTP2_HEADER_CONTENT_LOCATION.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_MD5 = HTTP2_HEADER_CONTENT_MD5.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_RANGE = HTTP2_HEADER_CONTENT_RANGE.asInstanceOf[js.Any], HTTP2_HEADER_CONTENT_TYPE = HTTP2_HEADER_CONTENT_TYPE.asInstanceOf[js.Any], HTTP2_HEADER_COOKIE = HTTP2_HEADER_COOKIE.asInstanceOf[js.Any], HTTP2_HEADER_DATE = HTTP2_HEADER_DATE.asInstanceOf[js.Any], HTTP2_HEADER_ETAG = HTTP2_HEADER_ETAG.asInstanceOf[js.Any], HTTP2_HEADER_EXPECT = HTTP2_HEADER_EXPECT.asInstanceOf[js.Any], HTTP2_HEADER_EXPIRES = HTTP2_HEADER_EXPIRES.asInstanceOf[js.Any], HTTP2_HEADER_FROM = HTTP2_HEADER_FROM.asInstanceOf[js.Any], HTTP2_HEADER_HOST = HTTP2_HEADER_HOST.asInstanceOf[js.Any], HTTP2_HEADER_HTTP2_SETTINGS = HTTP2_HEADER_HTTP2_SETTINGS.asInstanceOf[js.Any], HTTP2_HEADER_IF_MATCH = HTTP2_HEADER_IF_MATCH.asInstanceOf[js.Any], HTTP2_HEADER_IF_MODIFIED_SINCE = HTTP2_HEADER_IF_MODIFIED_SINCE.asInstanceOf[js.Any], HTTP2_HEADER_IF_NONE_MATCH = HTTP2_HEADER_IF_NONE_MATCH.asInstanceOf[js.Any], HTTP2_HEADER_IF_RANGE = HTTP2_HEADER_IF_RANGE.asInstanceOf[js.Any], HTTP2_HEADER_IF_UNMODIFIED_SINCE = HTTP2_HEADER_IF_UNMODIFIED_SINCE.asInstanceOf[js.Any], HTTP2_HEADER_KEEP_ALIVE = HTTP2_HEADER_KEEP_ALIVE.asInstanceOf[js.Any], HTTP2_HEADER_LAST_MODIFIED = HTTP2_HEADER_LAST_MODIFIED.asInstanceOf[js.Any], HTTP2_HEADER_LINK = HTTP2_HEADER_LINK.asInstanceOf[js.Any], HTTP2_HEADER_LOCATION = HTTP2_HEADER_LOCATION.asInstanceOf[js.Any], HTTP2_HEADER_MAX_FORWARDS = HTTP2_HEADER_MAX_FORWARDS.asInstanceOf[js.Any], HTTP2_HEADER_METHOD = HTTP2_HEADER_METHOD.asInstanceOf[js.Any], HTTP2_HEADER_PATH = HTTP2_HEADER_PATH.asInstanceOf[js.Any], HTTP2_HEADER_PREFER = HTTP2_HEADER_PREFER.asInstanceOf[js.Any], HTTP2_HEADER_PROXY_AUTHENTICATE = HTTP2_HEADER_PROXY_AUTHENTICATE.asInstanceOf[js.Any], HTTP2_HEADER_PROXY_AUTHORIZATION = HTTP2_HEADER_PROXY_AUTHORIZATION.asInstanceOf[js.Any], HTTP2_HEADER_PROXY_CONNECTION = HTTP2_HEADER_PROXY_CONNECTION.asInstanceOf[js.Any], HTTP2_HEADER_RANGE = HTTP2_HEADER_RANGE.asInstanceOf[js.Any], HTTP2_HEADER_REFERER = HTTP2_HEADER_REFERER.asInstanceOf[js.Any], HTTP2_HEADER_REFRESH = HTTP2_HEADER_REFRESH.asInstanceOf[js.Any], HTTP2_HEADER_RETRY_AFTER = HTTP2_HEADER_RETRY_AFTER.asInstanceOf[js.Any], HTTP2_HEADER_SCHEME = HTTP2_HEADER_SCHEME.asInstanceOf[js.Any], HTTP2_HEADER_SERVER = HTTP2_HEADER_SERVER.asInstanceOf[js.Any], HTTP2_HEADER_SET_COOKIE = HTTP2_HEADER_SET_COOKIE.asInstanceOf[js.Any], HTTP2_HEADER_STATUS = HTTP2_HEADER_STATUS.asInstanceOf[js.Any], HTTP2_HEADER_STRICT_TRANSPORT_SECURITY = HTTP2_HEADER_STRICT_TRANSPORT_SECURITY.asInstanceOf[js.Any], HTTP2_HEADER_TE = HTTP2_HEADER_TE.asInstanceOf[js.Any], HTTP2_HEADER_TRANSFER_ENCODING = HTTP2_HEADER_TRANSFER_ENCODING.asInstanceOf[js.Any], HTTP2_HEADER_UPGRADE = HTTP2_HEADER_UPGRADE.asInstanceOf[js.Any], HTTP2_HEADER_USER_AGENT = HTTP2_HEADER_USER_AGENT.asInstanceOf[js.Any], HTTP2_HEADER_VARY = HTTP2_HEADER_VARY.asInstanceOf[js.Any], HTTP2_HEADER_VIA = HTTP2_HEADER_VIA.asInstanceOf[js.Any], HTTP2_HEADER_WWW_AUTHENTICATE = HTTP2_HEADER_WWW_AUTHENTICATE.asInstanceOf[js.Any], HTTP2_METHOD_ACL = HTTP2_METHOD_ACL.asInstanceOf[js.Any], HTTP2_METHOD_BASELINE_CONTROL = HTTP2_METHOD_BASELINE_CONTROL.asInstanceOf[js.Any], HTTP2_METHOD_BIND = HTTP2_METHOD_BIND.asInstanceOf[js.Any], HTTP2_METHOD_CHECKIN = HTTP2_METHOD_CHECKIN.asInstanceOf[js.Any], HTTP2_METHOD_CHECKOUT = HTTP2_METHOD_CHECKOUT.asInstanceOf[js.Any], HTTP2_METHOD_CONNECT = HTTP2_METHOD_CONNECT.asInstanceOf[js.Any], HTTP2_METHOD_COPY = HTTP2_METHOD_COPY.asInstanceOf[js.Any], HTTP2_METHOD_DELETE = HTTP2_METHOD_DELETE.asInstanceOf[js.Any], HTTP2_METHOD_GET = HTTP2_METHOD_GET.asInstanceOf[js.Any], HTTP2_METHOD_HEAD = HTTP2_METHOD_HEAD.asInstanceOf[js.Any], HTTP2_METHOD_LABEL = HTTP2_METHOD_LABEL.asInstanceOf[js.Any], HTTP2_METHOD_LINK = HTTP2_METHOD_LINK.asInstanceOf[js.Any], HTTP2_METHOD_LOCK = HTTP2_METHOD_LOCK.asInstanceOf[js.Any], HTTP2_METHOD_MERGE = HTTP2_METHOD_MERGE.asInstanceOf[js.Any], HTTP2_METHOD_MKACTIVITY = HTTP2_METHOD_MKACTIVITY.asInstanceOf[js.Any], HTTP2_METHOD_MKCALENDAR = HTTP2_METHOD_MKCALENDAR.asInstanceOf[js.Any], HTTP2_METHOD_MKCOL = HTTP2_METHOD_MKCOL.asInstanceOf[js.Any], HTTP2_METHOD_MKREDIRECTREF = HTTP2_METHOD_MKREDIRECTREF.asInstanceOf[js.Any], HTTP2_METHOD_MKWORKSPACE = HTTP2_METHOD_MKWORKSPACE.asInstanceOf[js.Any], HTTP2_METHOD_MOVE = HTTP2_METHOD_MOVE.asInstanceOf[js.Any], HTTP2_METHOD_OPTIONS = HTTP2_METHOD_OPTIONS.asInstanceOf[js.Any], HTTP2_METHOD_ORDERPATCH = HTTP2_METHOD_ORDERPATCH.asInstanceOf[js.Any], HTTP2_METHOD_PATCH = HTTP2_METHOD_PATCH.asInstanceOf[js.Any], HTTP2_METHOD_POST = HTTP2_METHOD_POST.asInstanceOf[js.Any], HTTP2_METHOD_PRI = HTTP2_METHOD_PRI.asInstanceOf[js.Any], HTTP2_METHOD_PROPFIND = HTTP2_METHOD_PROPFIND.asInstanceOf[js.Any], HTTP2_METHOD_PROPPATCH = HTTP2_METHOD_PROPPATCH.asInstanceOf[js.Any], HTTP2_METHOD_PUT = HTTP2_METHOD_PUT.asInstanceOf[js.Any], HTTP2_METHOD_REBIND = HTTP2_METHOD_REBIND.asInstanceOf[js.Any], HTTP2_METHOD_REPORT = HTTP2_METHOD_REPORT.asInstanceOf[js.Any], HTTP2_METHOD_SEARCH = HTTP2_METHOD_SEARCH.asInstanceOf[js.Any], HTTP2_METHOD_TRACE = HTTP2_METHOD_TRACE.asInstanceOf[js.Any], HTTP2_METHOD_UNBIND = HTTP2_METHOD_UNBIND.asInstanceOf[js.Any], HTTP2_METHOD_UNCHECKOUT = HTTP2_METHOD_UNCHECKOUT.asInstanceOf[js.Any], HTTP2_METHOD_UNLINK = HTTP2_METHOD_UNLINK.asInstanceOf[js.Any], HTTP2_METHOD_UNLOCK = HTTP2_METHOD_UNLOCK.asInstanceOf[js.Any], HTTP2_METHOD_UPDATE = HTTP2_METHOD_UPDATE.asInstanceOf[js.Any], HTTP2_METHOD_UPDATEREDIRECTREF = HTTP2_METHOD_UPDATEREDIRECTREF.asInstanceOf[js.Any], HTTP2_METHOD_VERSION_CONTROL = HTTP2_METHOD_VERSION_CONTROL.asInstanceOf[js.Any], HTTP_STATUS_ACCEPTED = HTTP_STATUS_ACCEPTED.asInstanceOf[js.Any], HTTP_STATUS_ALREADY_REPORTED = HTTP_STATUS_ALREADY_REPORTED.asInstanceOf[js.Any], HTTP_STATUS_BAD_GATEWAY = HTTP_STATUS_BAD_GATEWAY.asInstanceOf[js.Any], HTTP_STATUS_BAD_REQUEST = HTTP_STATUS_BAD_REQUEST.asInstanceOf[js.Any], HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED = HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED.asInstanceOf[js.Any], HTTP_STATUS_CONFLICT = HTTP_STATUS_CONFLICT.asInstanceOf[js.Any], HTTP_STATUS_CONTINUE = HTTP_STATUS_CONTINUE.asInstanceOf[js.Any], HTTP_STATUS_CREATED = HTTP_STATUS_CREATED.asInstanceOf[js.Any], HTTP_STATUS_EXPECTATION_FAILED = HTTP_STATUS_EXPECTATION_FAILED.asInstanceOf[js.Any], HTTP_STATUS_FAILED_DEPENDENCY = HTTP_STATUS_FAILED_DEPENDENCY.asInstanceOf[js.Any], HTTP_STATUS_FORBIDDEN = HTTP_STATUS_FORBIDDEN.asInstanceOf[js.Any], HTTP_STATUS_FOUND = HTTP_STATUS_FOUND.asInstanceOf[js.Any], HTTP_STATUS_GATEWAY_TIMEOUT = HTTP_STATUS_GATEWAY_TIMEOUT.asInstanceOf[js.Any], HTTP_STATUS_GONE = HTTP_STATUS_GONE.asInstanceOf[js.Any], HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED = HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED.asInstanceOf[js.Any], HTTP_STATUS_IM_USED = HTTP_STATUS_IM_USED.asInstanceOf[js.Any], HTTP_STATUS_INSUFFICIENT_STORAGE = HTTP_STATUS_INSUFFICIENT_STORAGE.asInstanceOf[js.Any], HTTP_STATUS_INTERNAL_SERVER_ERROR = HTTP_STATUS_INTERNAL_SERVER_ERROR.asInstanceOf[js.Any], HTTP_STATUS_LENGTH_REQUIRED = HTTP_STATUS_LENGTH_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_LOCKED = HTTP_STATUS_LOCKED.asInstanceOf[js.Any], HTTP_STATUS_LOOP_DETECTED = HTTP_STATUS_LOOP_DETECTED.asInstanceOf[js.Any], HTTP_STATUS_METHOD_NOT_ALLOWED = HTTP_STATUS_METHOD_NOT_ALLOWED.asInstanceOf[js.Any], HTTP_STATUS_MISDIRECTED_REQUEST = HTTP_STATUS_MISDIRECTED_REQUEST.asInstanceOf[js.Any], HTTP_STATUS_MOVED_PERMANENTLY = HTTP_STATUS_MOVED_PERMANENTLY.asInstanceOf[js.Any], HTTP_STATUS_MULTIPLE_CHOICES = HTTP_STATUS_MULTIPLE_CHOICES.asInstanceOf[js.Any], HTTP_STATUS_MULTI_STATUS = HTTP_STATUS_MULTI_STATUS.asInstanceOf[js.Any], HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED = HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_NON_AUTHORITATIVE_INFORMATION = HTTP_STATUS_NON_AUTHORITATIVE_INFORMATION.asInstanceOf[js.Any], HTTP_STATUS_NOT_ACCEPTABLE = HTTP_STATUS_NOT_ACCEPTABLE.asInstanceOf[js.Any], HTTP_STATUS_NOT_EXTENDED = HTTP_STATUS_NOT_EXTENDED.asInstanceOf[js.Any], HTTP_STATUS_NOT_FOUND = HTTP_STATUS_NOT_FOUND.asInstanceOf[js.Any], HTTP_STATUS_NOT_IMPLEMENTED = HTTP_STATUS_NOT_IMPLEMENTED.asInstanceOf[js.Any], HTTP_STATUS_NOT_MODIFIED = HTTP_STATUS_NOT_MODIFIED.asInstanceOf[js.Any], HTTP_STATUS_NO_CONTENT = HTTP_STATUS_NO_CONTENT.asInstanceOf[js.Any], HTTP_STATUS_OK = HTTP_STATUS_OK.asInstanceOf[js.Any], HTTP_STATUS_PARTIAL_CONTENT = HTTP_STATUS_PARTIAL_CONTENT.asInstanceOf[js.Any], HTTP_STATUS_PAYLOAD_TOO_LARGE = HTTP_STATUS_PAYLOAD_TOO_LARGE.asInstanceOf[js.Any], HTTP_STATUS_PAYMENT_REQUIRED = HTTP_STATUS_PAYMENT_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_PERMANENT_REDIRECT = HTTP_STATUS_PERMANENT_REDIRECT.asInstanceOf[js.Any], HTTP_STATUS_PRECONDITION_FAILED = HTTP_STATUS_PRECONDITION_FAILED.asInstanceOf[js.Any], HTTP_STATUS_PRECONDITION_REQUIRED = HTTP_STATUS_PRECONDITION_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_PROCESSING = HTTP_STATUS_PROCESSING.asInstanceOf[js.Any], HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED = HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_RANGE_NOT_SATISFIABLE = HTTP_STATUS_RANGE_NOT_SATISFIABLE.asInstanceOf[js.Any], HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE = HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE.asInstanceOf[js.Any], HTTP_STATUS_REQUEST_TIMEOUT = HTTP_STATUS_REQUEST_TIMEOUT.asInstanceOf[js.Any], HTTP_STATUS_RESET_CONTENT = HTTP_STATUS_RESET_CONTENT.asInstanceOf[js.Any], HTTP_STATUS_SEE_OTHER = HTTP_STATUS_SEE_OTHER.asInstanceOf[js.Any], HTTP_STATUS_SERVICE_UNAVAILABLE = HTTP_STATUS_SERVICE_UNAVAILABLE.asInstanceOf[js.Any], HTTP_STATUS_SWITCHING_PROTOCOLS = HTTP_STATUS_SWITCHING_PROTOCOLS.asInstanceOf[js.Any], HTTP_STATUS_TEAPOT = HTTP_STATUS_TEAPOT.asInstanceOf[js.Any], HTTP_STATUS_TEMPORARY_REDIRECT = HTTP_STATUS_TEMPORARY_REDIRECT.asInstanceOf[js.Any], HTTP_STATUS_TOO_MANY_REQUESTS = HTTP_STATUS_TOO_MANY_REQUESTS.asInstanceOf[js.Any], HTTP_STATUS_UNAUTHORIZED = HTTP_STATUS_UNAUTHORIZED.asInstanceOf[js.Any], HTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS = HTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS.asInstanceOf[js.Any], HTTP_STATUS_UNORDERED_COLLECTION = HTTP_STATUS_UNORDERED_COLLECTION.asInstanceOf[js.Any], HTTP_STATUS_UNPROCESSABLE_ENTITY = HTTP_STATUS_UNPROCESSABLE_ENTITY.asInstanceOf[js.Any], HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE = HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE.asInstanceOf[js.Any], HTTP_STATUS_UPGRADE_REQUIRED = HTTP_STATUS_UPGRADE_REQUIRED.asInstanceOf[js.Any], HTTP_STATUS_URI_TOO_LONG = HTTP_STATUS_URI_TOO_LONG.asInstanceOf[js.Any], HTTP_STATUS_USE_PROXY = HTTP_STATUS_USE_PROXY.asInstanceOf[js.Any], HTTP_STATUS_VARIANT_ALSO_NEGOTIATES = HTTP_STATUS_VARIANT_ALSO_NEGOTIATES.asInstanceOf[js.Any], MAX_INITIAL_WINDOW_SIZE = MAX_INITIAL_WINDOW_SIZE.asInstanceOf[js.Any], MAX_MAX_FRAME_SIZE = MAX_MAX_FRAME_SIZE.asInstanceOf[js.Any], MIN_MAX_FRAME_SIZE = MIN_MAX_FRAME_SIZE.asInstanceOf[js.Any], NGHTTP2_CANCEL = NGHTTP2_CANCEL.asInstanceOf[js.Any], NGHTTP2_COMPRESSION_ERROR = NGHTTP2_COMPRESSION_ERROR.asInstanceOf[js.Any], NGHTTP2_CONNECT_ERROR = NGHTTP2_CONNECT_ERROR.asInstanceOf[js.Any], NGHTTP2_DEFAULT_WEIGHT = NGHTTP2_DEFAULT_WEIGHT.asInstanceOf[js.Any], NGHTTP2_ENHANCE_YOUR_CALM = NGHTTP2_ENHANCE_YOUR_CALM.asInstanceOf[js.Any])
      __obj.asInstanceOf[TypeoferrnoDEFAULTSETTINGSENABLEPUSH]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: TypeoferrnoDEFAULTSETTINGSENABLEPUSH] (val x: Self) extends AnyVal {
      
      inline def setDEFAULT_SETTINGS_ENABLE_PUSH(value: Double): Self = StObject.set(x, "DEFAULT_SETTINGS_ENABLE_PUSH", value.asInstanceOf[js.Any])
      
      inline def setDEFAULT_SETTINGS_HEADER_TABLE_SIZE(value: Double): Self = StObject.set(x, "DEFAULT_SETTINGS_HEADER_TABLE_SIZE", value.asInstanceOf[js.Any])
      
      inline def setDEFAULT_SETTINGS_INITIAL_WINDOW_SIZE(value: Double): Self = StObject.set(x, "DEFAULT_SETTINGS_INITIAL_WINDOW_SIZE", value.asInstanceOf[js.Any])
      
      inline def setDEFAULT_SETTINGS_MAX_FRAME_SIZE(value: Double): Self = StObject.set(x, "DEFAULT_SETTINGS_MAX_FRAME_SIZE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCEPT(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCEPT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCEPT_CHARSET(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCEPT_CHARSET", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCEPT_ENCODING(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCEPT_ENCODING", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCEPT_LANGUAGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCEPT_LANGUAGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCEPT_RANGES(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCEPT_RANGES", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_ALLOW_HEADERS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_ALLOW_METHODS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_EXPOSE_HEADERS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_REQUEST_HEADERS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD(value: String): Self = StObject.set(x, "HTTP2_HEADER_ACCESS_CONTROL_REQUEST_METHOD", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_AGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_AGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ALLOW(value: String): Self = StObject.set(x, "HTTP2_HEADER_ALLOW", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_AUTHORITY(value: String): Self = StObject.set(x, "HTTP2_HEADER_AUTHORITY", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_AUTHORIZATION(value: String): Self = StObject.set(x, "HTTP2_HEADER_AUTHORIZATION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CACHE_CONTROL(value: String): Self = StObject.set(x, "HTTP2_HEADER_CACHE_CONTROL", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONNECTION(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONNECTION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_DISPOSITION(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_DISPOSITION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_ENCODING(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_ENCODING", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_LANGUAGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_LANGUAGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_LENGTH(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_LENGTH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_LOCATION(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_LOCATION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_MD5(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_MD5", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_RANGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_RANGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_CONTENT_TYPE(value: String): Self = StObject.set(x, "HTTP2_HEADER_CONTENT_TYPE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_COOKIE(value: String): Self = StObject.set(x, "HTTP2_HEADER_COOKIE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_DATE(value: String): Self = StObject.set(x, "HTTP2_HEADER_DATE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_ETAG(value: String): Self = StObject.set(x, "HTTP2_HEADER_ETAG", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_EXPECT(value: String): Self = StObject.set(x, "HTTP2_HEADER_EXPECT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_EXPIRES(value: String): Self = StObject.set(x, "HTTP2_HEADER_EXPIRES", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_FROM(value: String): Self = StObject.set(x, "HTTP2_HEADER_FROM", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_HOST(value: String): Self = StObject.set(x, "HTTP2_HEADER_HOST", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_HTTP2_SETTINGS(value: String): Self = StObject.set(x, "HTTP2_HEADER_HTTP2_SETTINGS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_IF_MATCH(value: String): Self = StObject.set(x, "HTTP2_HEADER_IF_MATCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_IF_MODIFIED_SINCE(value: String): Self = StObject.set(x, "HTTP2_HEADER_IF_MODIFIED_SINCE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_IF_NONE_MATCH(value: String): Self = StObject.set(x, "HTTP2_HEADER_IF_NONE_MATCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_IF_RANGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_IF_RANGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_IF_UNMODIFIED_SINCE(value: String): Self = StObject.set(x, "HTTP2_HEADER_IF_UNMODIFIED_SINCE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_KEEP_ALIVE(value: String): Self = StObject.set(x, "HTTP2_HEADER_KEEP_ALIVE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_LAST_MODIFIED(value: String): Self = StObject.set(x, "HTTP2_HEADER_LAST_MODIFIED", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_LINK(value: String): Self = StObject.set(x, "HTTP2_HEADER_LINK", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_LOCATION(value: String): Self = StObject.set(x, "HTTP2_HEADER_LOCATION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_MAX_FORWARDS(value: String): Self = StObject.set(x, "HTTP2_HEADER_MAX_FORWARDS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_METHOD(value: String): Self = StObject.set(x, "HTTP2_HEADER_METHOD", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_PATH(value: String): Self = StObject.set(x, "HTTP2_HEADER_PATH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_PREFER(value: String): Self = StObject.set(x, "HTTP2_HEADER_PREFER", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_PROXY_AUTHENTICATE(value: String): Self = StObject.set(x, "HTTP2_HEADER_PROXY_AUTHENTICATE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_PROXY_AUTHORIZATION(value: String): Self = StObject.set(x, "HTTP2_HEADER_PROXY_AUTHORIZATION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_PROXY_CONNECTION(value: String): Self = StObject.set(x, "HTTP2_HEADER_PROXY_CONNECTION", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_RANGE(value: String): Self = StObject.set(x, "HTTP2_HEADER_RANGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_REFERER(value: String): Self = StObject.set(x, "HTTP2_HEADER_REFERER", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_REFRESH(value: String): Self = StObject.set(x, "HTTP2_HEADER_REFRESH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_RETRY_AFTER(value: String): Self = StObject.set(x, "HTTP2_HEADER_RETRY_AFTER", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_SCHEME(value: String): Self = StObject.set(x, "HTTP2_HEADER_SCHEME", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_SERVER(value: String): Self = StObject.set(x, "HTTP2_HEADER_SERVER", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_SET_COOKIE(value: String): Self = StObject.set(x, "HTTP2_HEADER_SET_COOKIE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_STATUS(value: String): Self = StObject.set(x, "HTTP2_HEADER_STATUS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_STRICT_TRANSPORT_SECURITY(value: String): Self = StObject.set(x, "HTTP2_HEADER_STRICT_TRANSPORT_SECURITY", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_TE(value: String): Self = StObject.set(x, "HTTP2_HEADER_TE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_TRANSFER_ENCODING(value: String): Self = StObject.set(x, "HTTP2_HEADER_TRANSFER_ENCODING", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_UPGRADE(value: String): Self = StObject.set(x, "HTTP2_HEADER_UPGRADE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_USER_AGENT(value: String): Self = StObject.set(x, "HTTP2_HEADER_USER_AGENT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_VARY(value: String): Self = StObject.set(x, "HTTP2_HEADER_VARY", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_VIA(value: String): Self = StObject.set(x, "HTTP2_HEADER_VIA", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_HEADER_WWW_AUTHENTICATE(value: String): Self = StObject.set(x, "HTTP2_HEADER_WWW_AUTHENTICATE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_ACL(value: String): Self = StObject.set(x, "HTTP2_METHOD_ACL", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_BASELINE_CONTROL(value: String): Self = StObject.set(x, "HTTP2_METHOD_BASELINE_CONTROL", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_BIND(value: String): Self = StObject.set(x, "HTTP2_METHOD_BIND", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_CHECKIN(value: String): Self = StObject.set(x, "HTTP2_METHOD_CHECKIN", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_CHECKOUT(value: String): Self = StObject.set(x, "HTTP2_METHOD_CHECKOUT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_CONNECT(value: String): Self = StObject.set(x, "HTTP2_METHOD_CONNECT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_COPY(value: String): Self = StObject.set(x, "HTTP2_METHOD_COPY", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_DELETE(value: String): Self = StObject.set(x, "HTTP2_METHOD_DELETE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_GET(value: String): Self = StObject.set(x, "HTTP2_METHOD_GET", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_HEAD(value: String): Self = StObject.set(x, "HTTP2_METHOD_HEAD", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_LABEL(value: String): Self = StObject.set(x, "HTTP2_METHOD_LABEL", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_LINK(value: String): Self = StObject.set(x, "HTTP2_METHOD_LINK", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_LOCK(value: String): Self = StObject.set(x, "HTTP2_METHOD_LOCK", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MERGE(value: String): Self = StObject.set(x, "HTTP2_METHOD_MERGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MKACTIVITY(value: String): Self = StObject.set(x, "HTTP2_METHOD_MKACTIVITY", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MKCALENDAR(value: String): Self = StObject.set(x, "HTTP2_METHOD_MKCALENDAR", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MKCOL(value: String): Self = StObject.set(x, "HTTP2_METHOD_MKCOL", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MKREDIRECTREF(value: String): Self = StObject.set(x, "HTTP2_METHOD_MKREDIRECTREF", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MKWORKSPACE(value: String): Self = StObject.set(x, "HTTP2_METHOD_MKWORKSPACE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_MOVE(value: String): Self = StObject.set(x, "HTTP2_METHOD_MOVE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_OPTIONS(value: String): Self = StObject.set(x, "HTTP2_METHOD_OPTIONS", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_ORDERPATCH(value: String): Self = StObject.set(x, "HTTP2_METHOD_ORDERPATCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_PATCH(value: String): Self = StObject.set(x, "HTTP2_METHOD_PATCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_POST(value: String): Self = StObject.set(x, "HTTP2_METHOD_POST", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_PRI(value: String): Self = StObject.set(x, "HTTP2_METHOD_PRI", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_PROPFIND(value: String): Self = StObject.set(x, "HTTP2_METHOD_PROPFIND", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_PROPPATCH(value: String): Self = StObject.set(x, "HTTP2_METHOD_PROPPATCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_PUT(value: String): Self = StObject.set(x, "HTTP2_METHOD_PUT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_REBIND(value: String): Self = StObject.set(x, "HTTP2_METHOD_REBIND", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_REPORT(value: String): Self = StObject.set(x, "HTTP2_METHOD_REPORT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_SEARCH(value: String): Self = StObject.set(x, "HTTP2_METHOD_SEARCH", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_TRACE(value: String): Self = StObject.set(x, "HTTP2_METHOD_TRACE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UNBIND(value: String): Self = StObject.set(x, "HTTP2_METHOD_UNBIND", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UNCHECKOUT(value: String): Self = StObject.set(x, "HTTP2_METHOD_UNCHECKOUT", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UNLINK(value: String): Self = StObject.set(x, "HTTP2_METHOD_UNLINK", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UNLOCK(value: String): Self = StObject.set(x, "HTTP2_METHOD_UNLOCK", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UPDATE(value: String): Self = StObject.set(x, "HTTP2_METHOD_UPDATE", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_UPDATEREDIRECTREF(value: String): Self = StObject.set(x, "HTTP2_METHOD_UPDATEREDIRECTREF", value.asInstanceOf[js.Any])
      
      inline def setHTTP2_METHOD_VERSION_CONTROL(value: String): Self = StObject.set(x, "HTTP2_METHOD_VERSION_CONTROL", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_ACCEPTED(value: Double): Self = StObject.set(x, "HTTP_STATUS_ACCEPTED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_ALREADY_REPORTED(value: Double): Self = StObject.set(x, "HTTP_STATUS_ALREADY_REPORTED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_BAD_GATEWAY(value: Double): Self = StObject.set(x, "HTTP_STATUS_BAD_GATEWAY", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_BAD_REQUEST(value: Double): Self = StObject.set(x, "HTTP_STATUS_BAD_REQUEST", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED(value: Double): Self = StObject.set(x, "HTTP_STATUS_BANDWIDTH_LIMIT_EXCEEDED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_CONFLICT(value: Double): Self = StObject.set(x, "HTTP_STATUS_CONFLICT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_CONTINUE(value: Double): Self = StObject.set(x, "HTTP_STATUS_CONTINUE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_CREATED(value: Double): Self = StObject.set(x, "HTTP_STATUS_CREATED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_EXPECTATION_FAILED(value: Double): Self = StObject.set(x, "HTTP_STATUS_EXPECTATION_FAILED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_FAILED_DEPENDENCY(value: Double): Self = StObject.set(x, "HTTP_STATUS_FAILED_DEPENDENCY", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_FORBIDDEN(value: Double): Self = StObject.set(x, "HTTP_STATUS_FORBIDDEN", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_FOUND(value: Double): Self = StObject.set(x, "HTTP_STATUS_FOUND", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_GATEWAY_TIMEOUT(value: Double): Self = StObject.set(x, "HTTP_STATUS_GATEWAY_TIMEOUT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_GONE(value: Double): Self = StObject.set(x, "HTTP_STATUS_GONE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED(value: Double): Self = StObject.set(x, "HTTP_STATUS_HTTP_VERSION_NOT_SUPPORTED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_IM_USED(value: Double): Self = StObject.set(x, "HTTP_STATUS_IM_USED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_INSUFFICIENT_STORAGE(value: Double): Self = StObject.set(x, "HTTP_STATUS_INSUFFICIENT_STORAGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_INTERNAL_SERVER_ERROR(value: Double): Self = StObject.set(x, "HTTP_STATUS_INTERNAL_SERVER_ERROR", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_LENGTH_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_LENGTH_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_LOCKED(value: Double): Self = StObject.set(x, "HTTP_STATUS_LOCKED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_LOOP_DETECTED(value: Double): Self = StObject.set(x, "HTTP_STATUS_LOOP_DETECTED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_METHOD_NOT_ALLOWED(value: Double): Self = StObject.set(x, "HTTP_STATUS_METHOD_NOT_ALLOWED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_MISDIRECTED_REQUEST(value: Double): Self = StObject.set(x, "HTTP_STATUS_MISDIRECTED_REQUEST", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_MOVED_PERMANENTLY(value: Double): Self = StObject.set(x, "HTTP_STATUS_MOVED_PERMANENTLY", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_MULTIPLE_CHOICES(value: Double): Self = StObject.set(x, "HTTP_STATUS_MULTIPLE_CHOICES", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_MULTI_STATUS(value: Double): Self = StObject.set(x, "HTTP_STATUS_MULTI_STATUS", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_NETWORK_AUTHENTICATION_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NON_AUTHORITATIVE_INFORMATION(value: Double): Self = StObject.set(x, "HTTP_STATUS_NON_AUTHORITATIVE_INFORMATION", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NOT_ACCEPTABLE(value: Double): Self = StObject.set(x, "HTTP_STATUS_NOT_ACCEPTABLE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NOT_EXTENDED(value: Double): Self = StObject.set(x, "HTTP_STATUS_NOT_EXTENDED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NOT_FOUND(value: Double): Self = StObject.set(x, "HTTP_STATUS_NOT_FOUND", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NOT_IMPLEMENTED(value: Double): Self = StObject.set(x, "HTTP_STATUS_NOT_IMPLEMENTED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NOT_MODIFIED(value: Double): Self = StObject.set(x, "HTTP_STATUS_NOT_MODIFIED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_NO_CONTENT(value: Double): Self = StObject.set(x, "HTTP_STATUS_NO_CONTENT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_OK(value: Double): Self = StObject.set(x, "HTTP_STATUS_OK", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PARTIAL_CONTENT(value: Double): Self = StObject.set(x, "HTTP_STATUS_PARTIAL_CONTENT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PAYLOAD_TOO_LARGE(value: Double): Self = StObject.set(x, "HTTP_STATUS_PAYLOAD_TOO_LARGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PAYMENT_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_PAYMENT_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PERMANENT_REDIRECT(value: Double): Self = StObject.set(x, "HTTP_STATUS_PERMANENT_REDIRECT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PRECONDITION_FAILED(value: Double): Self = StObject.set(x, "HTTP_STATUS_PRECONDITION_FAILED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PRECONDITION_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_PRECONDITION_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PROCESSING(value: Double): Self = StObject.set(x, "HTTP_STATUS_PROCESSING", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_PROXY_AUTHENTICATION_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_RANGE_NOT_SATISFIABLE(value: Double): Self = StObject.set(x, "HTTP_STATUS_RANGE_NOT_SATISFIABLE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE(value: Double): Self = StObject.set(x, "HTTP_STATUS_REQUEST_HEADER_FIELDS_TOO_LARGE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_REQUEST_TIMEOUT(value: Double): Self = StObject.set(x, "HTTP_STATUS_REQUEST_TIMEOUT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_RESET_CONTENT(value: Double): Self = StObject.set(x, "HTTP_STATUS_RESET_CONTENT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_SEE_OTHER(value: Double): Self = StObject.set(x, "HTTP_STATUS_SEE_OTHER", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_SERVICE_UNAVAILABLE(value: Double): Self = StObject.set(x, "HTTP_STATUS_SERVICE_UNAVAILABLE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_SWITCHING_PROTOCOLS(value: Double): Self = StObject.set(x, "HTTP_STATUS_SWITCHING_PROTOCOLS", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_TEAPOT(value: Double): Self = StObject.set(x, "HTTP_STATUS_TEAPOT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_TEMPORARY_REDIRECT(value: Double): Self = StObject.set(x, "HTTP_STATUS_TEMPORARY_REDIRECT", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_TOO_MANY_REQUESTS(value: Double): Self = StObject.set(x, "HTTP_STATUS_TOO_MANY_REQUESTS", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UNAUTHORIZED(value: Double): Self = StObject.set(x, "HTTP_STATUS_UNAUTHORIZED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS(value: Double): Self = StObject.set(x, "HTTP_STATUS_UNAVAILABLE_FOR_LEGAL_REASONS", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UNORDERED_COLLECTION(value: Double): Self = StObject.set(x, "HTTP_STATUS_UNORDERED_COLLECTION", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UNPROCESSABLE_ENTITY(value: Double): Self = StObject.set(x, "HTTP_STATUS_UNPROCESSABLE_ENTITY", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UNSUPPORTED_MEDIA_TYPE(value: Double): Self = StObject.set(x, "HTTP_STATUS_UNSUPPORTED_MEDIA_TYPE", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_UPGRADE_REQUIRED(value: Double): Self = StObject.set(x, "HTTP_STATUS_UPGRADE_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_URI_TOO_LONG(value: Double): Self = StObject.set(x, "HTTP_STATUS_URI_TOO_LONG", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_USE_PROXY(value: Double): Self = StObject.set(x, "HTTP_STATUS_USE_PROXY", value.asInstanceOf[js.Any])
      
      inline def setHTTP_STATUS_VARIANT_ALSO_NEGOTIATES(value: Double): Self = StObject.set(x, "HTTP_STATUS_VARIANT_ALSO_NEGOTIATES", value.asInstanceOf[js.Any])
      
      inline def setMAX_INITIAL_WINDOW_SIZE(value: Double): Self = StObject.set(x, "MAX_INITIAL_WINDOW_SIZE", value.asInstanceOf[js.Any])
      
      inline def setMAX_MAX_FRAME_SIZE(value: Double): Self = StObject.set(x, "MAX_MAX_FRAME_SIZE", value.asInstanceOf[js.Any])
      
      inline def setMIN_MAX_FRAME_SIZE(value: Double): Self = StObject.set(x, "MIN_MAX_FRAME_SIZE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_CANCEL(value: Double): Self = StObject.set(x, "NGHTTP2_CANCEL", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_COMPRESSION_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_COMPRESSION_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_CONNECT_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_CONNECT_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_DEFAULT_WEIGHT(value: Double): Self = StObject.set(x, "NGHTTP2_DEFAULT_WEIGHT", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_ENHANCE_YOUR_CALM(value: Double): Self = StObject.set(x, "NGHTTP2_ENHANCE_YOUR_CALM", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_ERR_FRAME_SIZE_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_ERR_FRAME_SIZE_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_ACK(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_ACK", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_END_HEADERS(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_END_HEADERS", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_END_STREAM(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_END_STREAM", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_NONE(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_NONE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_PADDED(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_PADDED", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLAG_PRIORITY(value: Double): Self = StObject.set(x, "NGHTTP2_FLAG_PRIORITY", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FLOW_CONTROL_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_FLOW_CONTROL_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_FRAME_SIZE_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_FRAME_SIZE_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_HTTP_1_1_REQUIRED(value: Double): Self = StObject.set(x, "NGHTTP2_HTTP_1_1_REQUIRED", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_INADEQUATE_SECURITY(value: Double): Self = StObject.set(x, "NGHTTP2_INADEQUATE_SECURITY", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_INTERNAL_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_INTERNAL_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_NO_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_NO_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_PROTOCOL_ERROR(value: Double): Self = StObject.set(x, "NGHTTP2_PROTOCOL_ERROR", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_REFUSED_STREAM(value: Double): Self = StObject.set(x, "NGHTTP2_REFUSED_STREAM", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SESSION_CLIENT(value: Double): Self = StObject.set(x, "NGHTTP2_SESSION_CLIENT", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SESSION_SERVER(value: Double): Self = StObject.set(x, "NGHTTP2_SESSION_SERVER", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_ENABLE_PUSH(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_ENABLE_PUSH", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_HEADER_TABLE_SIZE(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_HEADER_TABLE_SIZE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_INITIAL_WINDOW_SIZE(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_INITIAL_WINDOW_SIZE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_MAX_CONCURRENT_STREAMS(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_MAX_CONCURRENT_STREAMS", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_MAX_FRAME_SIZE(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_MAX_FRAME_SIZE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_MAX_HEADER_LIST_SIZE(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_MAX_HEADER_LIST_SIZE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_SETTINGS_TIMEOUT(value: Double): Self = StObject.set(x, "NGHTTP2_SETTINGS_TIMEOUT", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_CLOSED(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_CLOSED", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_CLOSED(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_CLOSED", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_HALF_CLOSED_LOCAL(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_HALF_CLOSED_LOCAL", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_HALF_CLOSED_REMOTE(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_HALF_CLOSED_REMOTE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_IDLE(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_IDLE", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_OPEN(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_OPEN", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_RESERVED_LOCAL(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_RESERVED_LOCAL", value.asInstanceOf[js.Any])
      
      inline def setNGHTTP2_STREAM_STATE_RESERVED_REMOTE(value: Double): Self = StObject.set(x, "NGHTTP2_STREAM_STATE_RESERVED_REMOTE", value.asInstanceOf[js.Any])
      
      inline def setPADDING_STRATEGY_CALLBACK(value: Double): Self = StObject.set(x, "PADDING_STRATEGY_CALLBACK", value.asInstanceOf[js.Any])
      
      inline def setPADDING_STRATEGY_MAX(value: Double): Self = StObject.set(x, "PADDING_STRATEGY_MAX", value.asInstanceOf[js.Any])
      
      inline def setPADDING_STRATEGY_NONE(value: Double): Self = StObject.set(x, "PADDING_STRATEGY_NONE", value.asInstanceOf[js.Any])
    }
  }
  
  trait TypeofimportedHttp2 extends StObject {
    
    val constants: TypeofconstantsErrno
  }
  object TypeofimportedHttp2 {
    
    inline def apply(constants: TypeofconstantsErrno): TypeofimportedHttp2 = {
      val __obj = js.Dynamic.literal(constants = constants.asInstanceOf[js.Any])
      __obj.asInstanceOf[TypeofimportedHttp2]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: TypeofimportedHttp2] (val x: Self) extends AnyVal {
      
      inline def setConstants(value: TypeofconstantsErrno): Self = StObject.set(x, "constants", value.asInstanceOf[js.Any])
    }
  }
  
  trait TypeofimportedOs extends StObject {
    
    val constants: Typeofconstants
  }
  object TypeofimportedOs {
    
    inline def apply(constants: Typeofconstants): TypeofimportedOs = {
      val __obj = js.Dynamic.literal(constants = constants.asInstanceOf[js.Any])
      __obj.asInstanceOf[TypeofimportedOs]
    }
    
    @scala.inline
    implicit open class MutableBuilder[Self <: TypeofimportedOs] (val x: Self) extends AnyVal {
      
      inline def setConstants(value: Typeofconstants): Self = StObject.set(x, "constants", value.asInstanceOf[js.Any])
    }
  }
}
