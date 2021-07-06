type VFileContents = string | Uint8Array

interface VFileOptions {
    contents?: VFileContents
}

interface VFile {
<F extends VFile>(input?: VFileContents | F | VFileOptions): F
}
