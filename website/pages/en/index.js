
const React = require('react');

class Users extends React.Component {
  render() {
    return (
      <div className="mainContainer" dangerouslySetInnerHTML={{
        // don't even ask why I had to do this
        __html: "<script> window.location.href = 'docs/readme.html';</script>"
      }}>
      </div>
    );
  }
}

module.exports = Users;
