import React from "react";
import Dropzone from "../../";

export default class Test extends React.Component {
  render() {
    return (
      <div>
        <Dropzone
          onDrop={(acceptedFiles, rejectedFiles, event) =>
            console.log(acceptedFiles, rejectedFiles, event)}
          onDragEnter={event => console.log(event)}
          onDragOver={event => console.log(event)}
          onDragLeave={event => console.log(event)}
          onDropAccepted={(files, event) => console.log(files, event)}
          onDropRejected={(files, event) => console.log(files, event)}
          onFileDialogCancel={() => console.log("abc")}
          minSize={2000}
          maxSize={Infinity}
          preventDropOnDocument
          noClick={false}
          noKeyboard={false}
          noDrag={false}
          noDragEventsBubbling={false}
          disabled
          multiple={false}
          accept="*.png"
        >
          {({getRootProps, getInputProps}) => (
            <div {...getRootProps()}>
              <input {...getInputProps()} />
            </div>
          )}
        </Dropzone>
      </div>
    );
  }
}
