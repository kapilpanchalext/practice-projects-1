import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import axios from 'axios';

import './FileUpload.scss'

/**
 * npm install --save @fortawesome/fontawesome-svg-core 
 * npm install --save @fortawesome/free-solid-svg-icons 
 * npm install --save @fortawesome/vue-fontawesome 
 */


const FileUpload = ({files, setFiles, removeFile}) => {
    
    const uploadHandler = event => {
        const file = event.target.files[0];
        file.isUploading = true;
        setFiles([...files, file]);

        //upload file
        const formData1 = new FormData();
        formData1.append(
            "newFile",
            file,
            file.name
        );

        axios.post('http://localhost:9001/upload', formData1)
        .then((res) => {
            file.isUploading = false;
            setFiles([...files, file]);
        })
        .catch((err) => {
            console.error(err);
            alert(err);
            removeFile(file.name);
        });

    }

    return (
        <>
            <div className="file-card">
                <div className="file-inputs">
                    <input type="file" onChange={uploadHandler}/>
                        <button>
                            <i>
                                <FontAwesomeIcon icon={faPlus}/>
                            </i>
                            Upload
                        </button>
                </div>

                <p className="main">Support Files</p>
                <p className="info">PDF, JPG, PNG</p>
            </div>
        </>
    )
}

export default FileUpload;