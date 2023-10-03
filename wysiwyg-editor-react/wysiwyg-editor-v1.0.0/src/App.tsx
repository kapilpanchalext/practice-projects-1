import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { useState } from 'react';


function App() {

  const [editorText, setEditorText] = useState('');  
  let intermediateVariable = '';

  const buttonClickHandler = (event: any) => {
    event.preventDefault();
    setEditorText(intermediateVariable);
    console.log('Button Clicked', editorText);
  };

  return (
    <div className='App'>
      <h2>CKEditor 5 React App</h2>
      <form onSubmit={buttonClickHandler}>
      <CKEditor
        editor={ ClassicEditor }
        data="<p>Hello from CKEditor 5!</p>"
        onReady={ ( editor: any ) => {
          // console.log( "CKEditor5 React Component is ready to use!", editor );
        } }
        onChange={ ( event: any, editor: { getData: () => any; } ) => {
          const data = editor.getData();
          // console.log( { event, editor, data } );
          // console.log('EDITOR DATA: ', data);
          intermediateVariable = data;
          // setEditorText(data);
        } }
      />
      <button>Save</button>
      </form>
      {editorText.toString()}
    </div>
  );
}

export default App
