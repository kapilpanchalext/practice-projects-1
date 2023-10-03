import './App.css';
import FileUpload from './FileUpload/FileUpload';
import { useState } from "react";

function App() {

  const [files, setFiles] = useState([{
    name: "myFile.pdf",
  }]);

  const removeFile = (filename) => {
    setFiles(files.filter(file => file.name !== filename));
  }

  console.log(files)

  return (
    <div className="App">
      <p className="title">Upload File</p>
      <FileUpload files={files} setFiles={setFiles} removeFile={removeFile}/>
    </div>
  );
}

export default App;
