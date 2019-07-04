import * as _firestore from '@google-cloud/firestore';

declare namespace admin.firestore {
  export import Firestore = _firestore.Firestore;
}

declare namespace admin {
  function firestore(str?: string): admin.firestore.Firestore;
}

export = admin;
